package br.com.covid19.controller;


import br.com.covid19.exceptions.QuestionsException;
import br.com.covid19.model.Questions;

import br.com.covid19.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    QuestionsService service;

    @GetMapping("/")
    public List<Questions> listOfQuestions(){
        try{
            return service.listOfQuestions();
        }catch (QuestionsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Questions findQuestion(@PathVariable Integer id){
        try{
            return service.findQuestions(id);
        }catch (QuestionsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

}

