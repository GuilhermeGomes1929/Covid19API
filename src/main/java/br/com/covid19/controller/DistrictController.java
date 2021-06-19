package br.com.covid19.controller;

import br.com.covid19.exceptions.DistrictException;
import br.com.covid19.model.District;
import br.com.covid19.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<District> listOfDisctricts(){
        try{
            return service.listOfDistricts();
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não há bairro cadastrados.");
        }
    }

    @GetMapping("/{id}")
    public District findDistrict(@PathVariable Integer id){
        try{
            return service.findDistrict(id);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bairro não encontrado.");
        }
    }

    @PostMapping("/register")
    public District registerNewDistrict(@RequestBody District district){
        try{
            return service.registerNewDistrict(district);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não foi possível cadastrar o bairro.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public District deleteDistrict(@PathVariable Integer id) {
        try{
            return service.deleteDistrict(id);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bairro não encontrado.");
        }
    }

    @PutMapping("/edit")
    public District editDistrict(@RequestBody District district){
        try{
            return service.registerNewDistrict(district);
        }catch (DistrictException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bairro não encontrado");
        }
    }

}
