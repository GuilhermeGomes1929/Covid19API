package br.com.covid19.controller;

import br.com.covid19.exceptions.DistrictException;
import br.com.covid19.model.District;
import br.com.covid19.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictService service;

    @GetMapping("/")
    public Page<District> listOfDisctricts(Pageable pageable){
        try{
            return service.listOfDistricts(pageable);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public District findDistrict(@PathVariable Integer id){
        try{
            return service.findDistrict(id);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    @PostMapping("/register")
    public District registerNewDistrict(@RequestBody District district){
        try{
            return service.registerNewDistrict(district, service.POST);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public District deleteDistrict(@PathVariable Integer id) {
        try{
            return service.deleteDistrict(id);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    @PutMapping("/edit")
    public District editDistrict(@RequestBody District district){
        try{
            return service.registerNewDistrict(district, service.PUT);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

}
