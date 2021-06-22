package br.com.covid19.controller;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.Research;
import br.com.covid19.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Research> listResearchs(){
        try{
            return service.listResearchs();
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há pesquisas cadastradas.");
        }
    }

    @GetMapping("/{id}")
    public Research findResearch(@PathVariable Long id){
        try{
            return service.findResearch(id);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesquisa não encontrada.");
        }
    }

    @PostMapping("/register")
    public Research registerNewResearch(@RequestBody Research research){
        try{
            return service.registerNewResearch(research);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível cadastrar a pesquisa.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Research deleteResearch(@PathVariable Long id){
        try{
            return service.deleteResearch(id);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesquisa não encontrada.");
        }
    }

    @PutMapping("/edit")
    public Research editResearch(@RequestBody Research research){
        try{
            return service.registerNewResearch(research);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível editar a pesquisa.");
        }
    }

    @GetMapping("/filter/count")
    public Integer getCountOfResearchEquals(@RequestBody Research research){
        try{
            return service.getCountOfSimilarResearchs(research);
        }catch (ResearchException e){ throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pesquisa enviada é nula.");}
    }

    @GetMapping("/filter/cascade")
    public HashMap getCascadeCount(@RequestBody Research research){
        try{
            return service.getCascadeCount(research);
        }catch (ResearchException e){throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pesquisa enviada é nula.");}
    }

    @GetMapping("/filter/research")
    public List<Research> getSimilarResearch(@RequestBody Research research){
        try {
            return service.getSimilarResearchs(research);
        }catch (ResearchException e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existem pesquisas similares a essa.");
        }
    }

    @GetMapping("/filter/percentage")
    public HashMap getPercentageOfResearchEquals(@RequestBody Research research){
        try{
            return service.getPercentageByResearch(research);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existem pesquisas similares a essa.");
        }
    }

    @GetMapping("/filter/cascade/percentage")
    public HashMap getCascadePercentage(@RequestBody Research research){
        try {
            return service.getCascadePercentage(research);
        }catch (ResearchException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A pesquisa enviada é nula.");
        }
    }
}

