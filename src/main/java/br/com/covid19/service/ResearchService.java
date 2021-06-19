package br.com.covid19.service;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.District;
import br.com.covid19.model.Occupation;
import br.com.covid19.model.Research;
import br.com.covid19.repository.CustomRepository;
import br.com.covid19.repository.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ResearchService {

    @Autowired
    ResearchRepository researchRepository;

    @Autowired
    CustomRepository repository;

    public List<Research> listResearchs(){
        List<Research> researchList = researchRepository.findAll();
        if (researchList.isEmpty()){
            throw new ResearchException();
        }
        return researchList;
    }

    public Research findResearch(Long id){
        Optional<Research> optionalResearch = researchRepository.findById(id);
        if (optionalResearch.isEmpty()){
            throw new ResearchException();
        }
        return optionalResearch.get();
    }

    public Research registerNewResearch(Research research){
        try{
            return researchRepository.save(research);
        }catch(Exception e){
            throw new ResearchException();
        }
    }

    public Research deleteResearch(Long id){
        Optional<Research> optionalResearch = researchRepository.findById(id);
        if (optionalResearch.isEmpty()){
            throw new ResearchException();
        }
        researchRepository.deleteById(id);
        return optionalResearch.get();
    }

    public List<Research> test(){
        Research research = new Research(6L, new District(1, "hello"), new Occupation(1, "ola"),
                2,true, true, true,null,null,null,null,null,null,null,null,null,null,null,null,null);
        ArrayList<String> string = new ArrayList<String>();
        string.add("p1");
        string.add("p2");
        string.add("p3");
        string.add("p4");
        string.add("p5");
        string.add("p6");

        return repository.find(string, research);
    }

}
