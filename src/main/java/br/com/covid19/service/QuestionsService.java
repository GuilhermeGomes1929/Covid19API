package br.com.covid19.service;

import br.com.covid19.exceptions.QuestionsException;
import br.com.covid19.model.Questions;
import br.com.covid19.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> listOfQuestions(){
        List<Questions> questionsList = questionsRepository.findAll();
        if (questionsList.isEmpty()){
            throw new QuestionsException();
        }
        return questionsList;
    }

    public Questions findQuestions(Integer id) {
        Optional<Questions> optionalQuestions = questionsRepository.findById(id);
        if (optionalQuestions.isEmpty()){
            throw new QuestionsException();
        }
        return optionalQuestions.get();
    }

    public Questions registerNewQuestion(Questions questions) {
        if (questions.getSentence() == null){
            throw new QuestionsException();
        }else if(questionsRepository.save(questions).getSentence() == null){
            throw new QuestionsException();
        }
        return questionsRepository.save(questions);
    }

    public Questions deleteQuestions(Integer id) {
        Optional<Questions> questions = questionsRepository.findById(id);
        if (questions.isEmpty()){
            throw new QuestionsException();
        }
        questionsRepository.deleteById(id);
        return questions.get();
    }

}