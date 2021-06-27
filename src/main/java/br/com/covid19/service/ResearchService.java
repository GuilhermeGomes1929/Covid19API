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
            Float total = Float.valueOf(repository.getAllResearchCount());
            Float count = Float.valueOf(repository.getCountByResearch(research));
            Float percentage = (count * 100) / total;

            HashMap response = new HashMap();
            response.put("total", total);
            response.put("count", count);
            response.put("percentage", percentage);

            return response;
        }
    }


    //This method works like the getCascadeCountByResearch method, but it returns the percentage, not the count.
    public HashMap getCascadePercentage(PriorityOrder research){
        if (research == null){
            throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
        }else{
            if (research.getPriority().isEmpty()){
                throw new ResearchException("Pesquisa nula. Especifique uma pesquisa válida.");
            }
            HashMap cascadeCount = repository.getCascadeCountByResearch(research);
            HashMap response = new HashMap();

            Float total = Float.valueOf(cascadeCount.get("total").toString());
            response.put("total", cascadeCount.get("total"));

            for (int i = 0; i < research.getPriority().size(); i++){
                Float percentage = (Float.parseFloat(cascadeCount.get(research.getPriority().get(i)).toString()) * 100) / total;
                response.put(research.getPriority().get(i), percentage);
                total = Float.parseFloat(cascadeCount.get(research.getPriority().get(i)).toString());
            }
            return response;

        }


    }

}