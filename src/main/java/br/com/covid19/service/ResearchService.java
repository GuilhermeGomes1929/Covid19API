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

    public static Integer POST = 1;
    public static Integer PUT = 2;

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
            throw new ResearchException("Não há pesquisas cadastradas.");
        }
        return researchList;
    }

    public Research findResearch(Long id){
        Optional<Research> optionalResearch = researchRepository.findById(id);
        if (optionalResearch.isEmpty()){
            throw new ResearchException("Pesquisa de id "+id+" não encontrada.");
        }
        return optionalResearch.get();
    }

    public Research registerNewResearch(Research research, Integer requestMethod){
        if(research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }
        if (requestMethod == POST ){
            return researchRepository.save(research);
        }else if(requestMethod == PUT){
            if (research.getId() == null){
                throw new ResearchException("Id nulo. Especifique o id da pesquisa para realizar a edição.");
            }
            if (researchRepository.findById(research.getId()).isEmpty()){
                throw new ResearchException("Pesquisa com id "+research.getId()+" não existe.");
            }else{
                return researchRepository.save(research);
            }
        }else{
            throw new ResearchException("Método inválido");
        }
    }

    public Research deleteResearch(Long id){
        if (id == null){
            throw new ResearchException("Id nulo. Especifique o id da pesquisa.");
        }else{
            Optional<Research> optionalResearch = researchRepository.findById(id);
            if (optionalResearch.isEmpty()){
                throw new ResearchException("Pesquisa de id "+id+" não encontrada.");
            }
            researchRepository.deleteById(id);
            return optionalResearch.get();
        }
    }

    public HashMap getCountOfSimilarResearchs(Research research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else if(repository.getCountByResearch(research, createStringList(research)) == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap response = new HashMap();
            response.put("total", Integer.valueOf(repository.getCountByResearch(research, createStringList(research))));
            return response;
        }
    }

    public HashMap getCascadeCount(Research research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else if(repository.getCascadeCountByResearch(research, createStringList(research)) == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap cascade = repository.getCascadeCountByResearch(research, createStringList(research));
            return cascade;
        }
    }

    public List<Research> getSimilarResearchs(Research research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            List<Research> response = repository.getResearchsByExample(research, createStringList(research));
            if (response == null){
                throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
            }
            return response;
        }
    }

    public HashMap getPercentageByResearch(Research research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap response = repository.getPercentageByResearch(research, createStringList(research));
            if (response == null){
                throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida");
            }
            return response;
        }
    }

    public HashMap getCascadePercentage(Research research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap response = repository.getCascadePercentage(research, createStringList(research));
            if (response == null){
                throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
            }
            return response;
        }
    }

}