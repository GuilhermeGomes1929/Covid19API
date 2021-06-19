package br.com.covid19.controller;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.Research;
import br.com.covid19.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

}
