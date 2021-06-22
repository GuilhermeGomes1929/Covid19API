package br.com.covid19.service;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.Research;
import br.com.covid19.repository.StatisticRepository;
import br.com.covid19.repository.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ResearchService {

    @Autowired
    ResearchRepository researchRepository;

    @Autowired
    StatisticRepository repository;

    public ArrayList<String> createStringList(Research research){
        ArrayList<String> stringList = new ArrayList<String>();

        if (research.getP1() != null){ stringList.add("p1"); }
        if (research.getP2() != null){ stringList.add("p2"); }
        if (research.getP3() != null){ stringList.add("p3");}
        if (research.getP4() != null){ stringList.add("p4");}
        if (research.getP5() != null){ stringList.add("p5");}
        if (research.getP6() != null){ stringList.add("p6");}
        if (research.getP7() != null){ stringList.add("p7");}
        if (research.getP8() != null){ stringList.add("p8");}
        if (research.getP9() != null){ stringList.add("p9");}
        if (research.getP10() != null){ stringList.add("p10");}
        if (research.getP11() != null){ stringList.add("p11");}
        if (research.getP12() != null){ stringList.add("p12");}
        if (research.getP13() != null){ stringList.add("p13");}
        if (research.getP14() != null){ stringList.add("p14");}
        if (research.getP15() != null){ stringList.add("p15");}
        if (research.getP16() != null){ stringList.add("p16");}
        if (research.getP17() != null){ stringList.add("p17");}
        if (research.getP18() != null){ stringList.add("p18");}
        if (research.getP19() != null){ stringList.add("p19");}

        return stringList;
    }

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

    public Integer getCountOfSimilarResearchs(Research research){

        String count = repository.getCountByResearch(research, createStringList(research));

        if (count == null){
            throw new ResearchException();
        }
        return Integer.valueOf(count);
    }

    public HashMap getCascadeCount(Research research){
        HashMap cascade = repository.getCascadeCountByResearch(research, createStringList(research));
        if (cascade == null){
            throw new ResearchException();
        }
        return cascade;
    }

    public List<Research> getSimilarResearchs(Research research){
        List<Research> response = repository.getResearchsByExample(research, createStringList(research));
        if (response.isEmpty()){
            throw new ResearchException();
        }
        return response;
    }

    public HashMap getPercentageByResearch(Research research){
        HashMap response = repository.getPercentageByResearch(research, createStringList(research));
        if (response.isEmpty()){
            throw new ResearchException();
        }
        return response;
    }

    public HashMap getCascadePercentage(Research research){
        HashMap response = repository.getCascadePercentage(research, createStringList(research));
        if (response.isEmpty()){
            throw new ResearchException();
        }
        return response;

    }

}
