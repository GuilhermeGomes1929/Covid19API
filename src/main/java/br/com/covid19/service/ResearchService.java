package br.com.covid19.service;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.Research;
import br.com.covid19.repository.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ResearchService {

    @Autowired
    ResearchRepository researchRepository;

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
        if (research.getP1() == null){
            throw new ResearchException();
        }else if (researchRepository.save(research).getP1()==null){
            throw new ResearchException();
        }
        return researchRepository.save(research);
    }

    public Research deleteResearch(Long id){
        Optional<Research> optionalResearch = researchRepository.findById(id);
        if (optionalResearch.isEmpty()){
            throw new ResearchException();
        }
        researchRepository.deleteById(id);
        return optionalResearch.get();
    }

}
