package br.com.covid19.repository;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.District;
import br.com.covid19.model.PriorityOrder;
import br.com.covid19.model.Research;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StatisticRepository {

    private final EntityManager manager;

    //This repository can make different types of statistics.
    public StatisticRepository(EntityManager manager) {
        this.manager = manager;
    }

    //This method returns a casacade of count.
    //Example: there are 10 researchs in database.
    //You send a research whose first question is true and the second is false.
    //This method will return the number of researchs in database whose the first question is true and
    //will return the number of the previous researchs whose the second question is false;
    public HashMap getCascadeCountByResearch(PriorityOrder research) {

        if (research.getPriority().isEmpty()){
            return null;
        }

        HashMap response = new HashMap();
        HashMap researchContent = research.getResearch().getHashMap();
        ArrayList<String> priority = research.getPriority();
        String stringQuery = "SELECT COUNT(R) FROM Research as R ";
        String condition = "WHERE";
        Query query = manager.createQuery(stringQuery);

        response.put("total", query.getSingleResult().toString());

        for (int i = 0; i < priority.size(); i++){
            stringQuery += condition + " R."+priority.get(i)+" = :"+ priority.get(i);
            condition = " AND ";
            query = manager.createQuery(stringQuery);

            for (int j = 0; j <= i; j++){

                query.setParameter(priority.get(j), researchContent.get(priority.get(j)));

            }
            response.put(priority.get(i), query.getSingleResult().toString());
        }
        return response;
    }

    //This method returns the number of researchs that is similar to what you sent.
    public String getCountByResearch(Research research){
        HashMap<String, Object> content = research.getHashMap();
        if (content.isEmpty()){
            return null;
        }
        String stringQuery = "SELECT COUNT(R) FROM Research as R ";
        String condition = "WHERE";

        for (String key : content.keySet()){

            stringQuery += condition + " R."+key+" = :"+key;
            condition = " AND ";

        }

        Query query =  manager.createQuery(stringQuery);

        for (String key : content.keySet()){
            query.setParameter(key, content.get(key));
        }

        return query.getSingleResult().toString();
    }

    //This method returns a list of researchs that is similar to research  you sent.
    public List<Research> getResearchsByExample(Research research){

        String stringQuery = "SELECT R FROM Research as R ";
        String condition = "WHERE";

        HashMap<String, Object> contentResearch = research.getHashMap();
        if (contentResearch.isEmpty()){
            return null;
        }

        for (String key : contentResearch.keySet()){

            stringQuery += condition + " R."+key+" = :"+key;
            condition = " AND ";

        }

        TypedQuery<Research> query =  manager.createQuery(stringQuery, Research.class);

        for (String key : contentResearch.keySet()){
            query.setParameter(key, contentResearch.get(key));
        }

        return query.getResultList();
    }

    //This method returns the percentage of researchs similar to what you sent.
    public String getAllResearchCount(){
        Query query = manager.createQuery("SELECT COUNT(R) FROM Research as R");
        return query.getSingleResult().toString();
    }


}
