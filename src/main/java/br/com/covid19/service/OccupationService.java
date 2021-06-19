package br.com.covid19.service;

import br.com.covid19.exceptions.OccupationException;
import br.com.covid19.model.Occupation;
import br.com.covid19.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {

    @Autowired
    OccupationRepository occupationRepository;

    public List<Occupation> listOfOccupation(){
        List<Occupation> occupationList = occupationRepository.findAll();
        if (occupationList.isEmpty()){
            throw new OccupationException();
        }
        return occupationList;
    }

    public Occupation findOccupation(Integer id){
        Optional<Occupation> optionalOccupation = occupationRepository.findById(id);
        if (optionalOccupation.isEmpty()){
            throw new OccupationException();
        }
        return optionalOccupation.get();
    }

    public Occupation registerNewOccupation(Occupation occupation){
        if (occupation.getName() == null){
            throw new OccupationException();
        }else if(occupationRepository.save(occupation).getName() == null){
            throw new OccupationException();
        }
        return occupationRepository.save(occupation);
    }

    public Occupation deleteOccupation(Integer id){
        Optional<Occupation> optionalOccupation = occupationRepository.findById(id);
        if (optionalOccupation.isEmpty()){
            throw new OccupationException();
        }
        occupationRepository.deleteById(id);
        return optionalOccupation.get();
    }

}
