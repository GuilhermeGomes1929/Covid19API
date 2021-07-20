package br.com.covid19.service;

import br.com.covid19.exceptions.QuestionsException;
import br.com.covid19.model.Questions;
import br.com.covid19.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public Page<Questions> listOfQuestions(Pageable pageable){
        Page<Questions> questionsList = questionsRepository.findAll(pageable);
        if (questionsList.isEmpty()){
            throw new QuestionsException("Não há perguntas cadastradas no banco de dados.");
        }
        return questionsList;
    }

    public Questions findQuestions(Integer id) {
        Optional<Questions> optionalQuestions = questionsRepository.findById(id);
        if (optionalQuestions.isEmpty()){
            throw new QuestionsException("Pergunta de id "+id+" não encontrada.");
        }
        return optionalQuestions.get();
    }

}
