package br.com.covid19.service;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.PriorityOrder;
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
        }else if(repository.getCountByResearch(research) == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap response = new HashMap();
            response.put("total", Integer.valueOf(repository.getCountByResearch(research)));
            return response;
        }
    }

    public HashMap getCascadeCount(PriorityOrder research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else if(repository.getCascadeCountByResearch(research) == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap cascade = repository.getCascadeCountByResearch(research);
            return cascade;
        }
    }

    public List<Research> getSimilarResearchs(Research research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            List<Research> response = repository.getResearchsByExample(research);
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
            HashMap response = repository.getPercentageByResearch(research);
            if (response == null){
                throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida");
            }
            return response;
        }
    }

    public HashMap getCascadePercentage(PriorityOrder research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            HashMap response = repository.getCascadePercentage(research);
            if (response == null){
                throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
            }
            return response;
        }
    }

}