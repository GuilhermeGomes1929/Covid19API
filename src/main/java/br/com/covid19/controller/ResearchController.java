package br.com.covid19.controller;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.PriorityOrder;
import br.com.covid19.model.Research;
import br.com.covid19.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/research")
public class ResearchController {

    @Autowired
    ResearchService service;

    @GetMapping("/")
    public Page<Research> listResearchs(@PageableDefault Pageable pageable){
        try{
            return service.listResearchs(pageable);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Research findResearch(@PathVariable Long id){
        try{
            return service.findResearch(id);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/register")
    public Research registerNewResearch(@RequestBody Research research){
        try{
            return service.registerNewResearch(research, service.POST);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public Research deleteResearch(@PathVariable Long id){
        try{
            return service.deleteResearch(id);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/edit")
    public Research editResearch(@RequestBody Research research){
        try{
            return service.registerNewResearch(research, service.PUT);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/filter/count")
    public HashMap getCountOfResearchEquals(@RequestBody Research research){
        try{
            return service.getCountOfSimilarResearchs(research);
        }catch (ResearchException e){ throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());}
    }

    @GetMapping("/filter/cascade")
    public HashMap getCascadeCount(@RequestBody PriorityOrder research){
        try{
            return service.getCascadeCount(research);
        }catch (ResearchException e){throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());}
    }

    @GetMapping("/filter/research")
    public Page<Research> getSimilarResearch(@RequestBody Research research, Pageable pageable){
        try {
            return service.getSimilarResearchs(research, pageable);
        }catch (ResearchException e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/filter/percentage")
    public HashMap getPercentageOfResearchEquals(@RequestBody Research research){
        try{
            return service.getPercentageByResearch(research);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/filter/cascade-percentage")
    public HashMap getCascadePercentage(@RequestBody PriorityOrder research){
        try {
            return service.getCascadePercentage(research);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

