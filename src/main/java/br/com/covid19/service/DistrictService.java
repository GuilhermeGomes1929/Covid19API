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

    @Autowired
    private DistrictRepository districtRepository;

    public List<District> listOfDistricts(){
        List<District> districtList = districtRepository.findAll();
        if (districtList.isEmpty()){
            throw new DistrictException();
        }
        return districtRepository.findAll();
    }

    public District findDistrict(Integer id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (optionalDistrict.isEmpty()){
            throw new DistrictException();
        }
        return optionalDistrict.get();
    }

    public District registerNewDistrict(District district) {
        if (district.getName() == null){
            throw new DistrictException();
        }else if(districtRepository.save(district).getName() == null){
            throw new DistrictException();
        }
        return districtRepository.save(district);
    }

    public District deleteDistrict(Integer id) {
        Optional<District> district = districtRepository.findById(id);
        if (district.isEmpty()){
            throw new DistrictException();
        }
        districtRepository.deleteById(id);
        return district.get();
    }
}
