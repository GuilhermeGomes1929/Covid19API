package br.com.covid19.service;

import br.com.covid19.exceptions.OccupationException;
import br.com.covid19.model.Occupation;
import br.com.covid19.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {

    public static final Integer POST = 1;
    public static final Integer PUT = 2;

    @Autowired
    OccupationRepository occupationRepository;

    public Page<Occupation> listOfOccupation(Pageable pageable){
        Page<Occupation> occupationList = occupationRepository.findAll(pageable);
        if (occupationList.isEmpty()){
            throw new OccupationException("Não há profissões cadastradas no banco de dados.");
        }
        return occupationList;
    }

    public Occupation findOccupation(Integer id){
        Optional<Occupation> optionalOccupation = occupationRepository.findById(id);
        if (optionalOccupation.isEmpty()){
            throw new OccupationException("Profissão de id "+id+" não encontrada.");
        }
        return optionalOccupation.get();
    }

    public Occupation registerNewOccupation(Occupation occupation, Integer requestMethod){
        if (occupation == null){
            throw new OccupationException("Profissão nula. Especifique uma profissão válida.");
        }else if (occupation.getName() == null){
            throw new OccupationException("Nome nulo. Especifique o nome da profissão.");
        }
        if (requestMethod == this.POST){
            return occupationRepository.save(occupation);
        }else if(requestMethod == this.PUT){
            if (occupation.getId() == null){
                throw new OccupationException("Id nulo. Especifique o id da profissão para realizar a edição.");
            }
            if (occupationRepository.findById(occupation.getId()).isEmpty()){
                throw new OccupationException("Profissão com id "+occupation.getId()+" não existe.");
            }else{
                return occupationRepository.save(occupation);
            }
        }else {
            throw new OccupationException("Método inválido.");
        }
    }

    public Occupation deleteOccupation(Integer id){
        if(id == null){
            throw new OccupationException("Id nulo. Especifique o id da profissão.");
        }else{
            Optional<Occupation> optionalOccupation = occupationRepository.findById(id);
            if (optionalOccupation.isEmpty()){
                throw new OccupationException("Profissão de id "+id+" não encontrada.");
            }
            occupationRepository.deleteById(id);
            return optionalOccupation.get();
        }
    }

}
