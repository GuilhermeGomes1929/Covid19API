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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não há questões cadastradas.");
        }
    }

    @GetMapping("/{id}")
    public Questions findQuestion(@PathVariable Integer id){
        try{
            return service.findQuestions(id);
        }catch (QuestionsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Questão não encontrada.");
        }
    }

    @PostMapping("/register")
    public Questions registerNewQuestion(@RequestBody Questions questions){
        try {
            return service.registerNewQuestion(questions);
        }catch (QuestionsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não foi possível cadastrar a questão.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Questions deleteQuestions(@PathVariable Integer id) {
        try{
            return service.deleteQuestions(id);
        }catch (QuestionsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Questão não encontrada.");
        }
    }

    @PutMapping("/edit")
    public Questions editQuestion(@RequestBody Questions questions){
        try{
            return service.registerNewQuestion(questions);
        }catch (QuestionsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Questão não encontrada");
        }
    }

}

