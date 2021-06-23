package br.com.covid19.service;

import br.com.covid19.exceptions.DistrictException;
import br.com.covid19.model.District;
import br.com.covid19.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    public static Integer POST = 1;
    public static Integer PUT = 2;

    @Autowired
    private DistrictRepository districtRepository;

    public List<District> listOfDistricts(){
        List<District> districtList = districtRepository.findAll();
        if (districtList.isEmpty()){
            throw new DistrictException("Não há bairros cadastrados no banco de dados.");
        }
        return districtRepository.findAll();
    }

    public District findDistrict(Integer id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (optionalDistrict.isEmpty()){
            throw new DistrictException("Bairro de id "+id+" não encontrado.");
        }
        return optionalDistrict.get();
    }

    public District registerNewDistrict(District district, Integer requestMethod) {
        if (district == null){
            throw new DistrictException("Bairro nulo. Especifique um bairro válido.");
        }else if (district.getName() == null){
            throw new DistrictException("Nome nulo. Especifique o nome do bairro.");
        }
        if (requestMethod == POST){
            return districtRepository.save(district);
        }else if (requestMethod == PUT){
            if (district.getId() == null){
                throw new DistrictException("Id nulo. Especifique o id do bairro para realizar a edição.");
            }if (districtRepository.findById(district.getId()).isEmpty()){
                throw new DistrictException("Bairro com id "+district.getId()+" não existe.");
            }else{
                return districtRepository.save(district);
            }
        }else{
            throw new DistrictException("Método inválido.");
        }
    }

    public District deleteDistrict(Integer id) {
        if (id == null){
            throw new DistrictException("Id nulo. Especifique o id do bairro.");
        }else{
            Optional<District> district = districtRepository.findById(id);
            if (district.isEmpty()){
                throw new DistrictException("Bairro de id "+id+" não encontrado.");
            }
            districtRepository.deleteById(id);
            return district.get();
        }
    }
}
