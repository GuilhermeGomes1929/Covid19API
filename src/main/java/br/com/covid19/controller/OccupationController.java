package br.com.covid19.controller;

import br.com.covid19.exceptions.OccupationException;
import br.com.covid19.model.Occupation;
import br.com.covid19.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/occupation")
public class OccupationController {

    @Autowired
    OccupationService occupationService;

    @GetMapping("/")
    public Page<Occupation> listOfOccupation(Pageable pageable){
        try {
            return occupationService.listOfOccupation(pageable);
        }catch (OccupationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Occupation findOccupation(@PathVariable Integer id){
        try {
            return occupationService.findOccupation(id);
        }catch (OccupationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/register")
    public Occupation registerNewOccupation(@RequestBody Occupation occupation){
        try {
            return occupationService.registerNewOccupation(occupation, occupationService.POST);
        }catch (OccupationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public Occupation deleteOccupation(@PathVariable Integer id){
        try {
            return occupationService.deleteOccupation(id);
        }catch (OccupationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/edit")
    public Occupation editOccupation(@RequestBody Occupation occupation){
        try {
            return occupationService.registerNewOccupation(occupation, occupationService.PUT);
        }catch (OccupationException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
