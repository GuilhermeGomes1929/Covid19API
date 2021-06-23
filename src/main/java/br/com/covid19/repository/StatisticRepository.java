package br.com.covid19.repository;

import br.com.covid19.exceptions.ResearchException;
import br.com.covid19.model.District;
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
    public HashMap getCascadeCountByResearch(Research research, ArrayList<String> questionList) {

        if (questionList.isEmpty()){
            return null;
        }

        HashMap hashMap = new HashMap();
        String stringQuery = "SELECT COUNT(R) FROM Research as R ";
        String condition = "WHERE";

        Query query = manager.createQuery(stringQuery);
        hashMap.put("total", query.getSingleResult().toString());

        for (int i = 0; i < questionList.size(); i++){
            stringQuery += condition + " R."+questionList.get(i)+" = :"+ questionList.get(i);
            condition = " AND ";

            query = manager.createQuery(stringQuery);

            for (int j = 0; j <= i; j++){

                if (questionList.get(j).equals("p1")){
                    query.setParameter("p1", research.getP1());
                }
                if (questionList.get(j).equals("p2")){
                    query.setParameter("p2", research.getP2());
                }
                if (questionList.get(j).equals("p3")){
                    query.setParameter("p3", research.getP3());
                }
                if (questionList.get(j).equals("p4")){
                    query.setParameter("p4", research.getP4());
                }
                if (questionList.get(j).equals("p5")){
                    query.setParameter("p5", research.getP5());
                }
                if (questionList.get(j).equals("p6")){
                    query.setParameter("p6", research.getP6());
                }
                if (questionList.get(j).equals("p7")){
                    query.setParameter("p7", research.getP7());
                }
                if (questionList.get(j).equals("p8")){
                    query.setParameter("p8", research.getP8());
                }
                if (questionList.get(j).equals("p9")){
                    query.setParameter("p9", research.getP9());
                }
                if (questionList.get(j).equals("p10")){
                    query.setParameter("p10", research.getP10());
                }
                if (questionList.get(j).equals("p11")){
                    query.setParameter("p11", research.getP11());
                }
                if (questionList.get(j).equals("p12")){
                    query.setParameter("p12", research.getP12());
                }
                if (questionList.get(j).equals("p13")){
                    query.setParameter("p13", research.getP13());
                }
                if (questionList.get(j).equals("p14")){
                    query.setParameter("p14", research.getP14());
                }
                if (questionList.get(j).equals("p15")){
                    query.setParameter("p15", research.getP15());
                }
                if (questionList.get(j).equals("p16")){
                    query.setParameter("p16", research.getP16());
                }
                if (questionList.get(j).equals("p17")){
                    query.setParameter("p17", research.getP17());
                }
                if (questionList.get(j).equals("p18")){
                    query.setParameter("p18", research.getP18());
                }
                if (questionList.get(j).equals("p19")){
                    query.setParameter("p19", research.getP19());
                }
            }

            hashMap.put(questionList.get(i), query.getSingleResult().toString());
        }
        return hashMap;
    }

    //This method returns the number of researchs that is similar to what you sent.
    public String getCountByResearch(Research research, ArrayList<String> questionList){
        String query = "SELECT COUNT(R) FROM Research as R ";
        String condition = "WHERE";

        if (questionList.isEmpty()){
            return null;
        }

        for (int i = 0; i < questionList.size(); i++){

            query += condition + " R."+questionList.get(i)+" = :"+questionList.get(i);
            condition = " AND ";

        }

        Query q =  manager.createQuery(query);


        for (int i = 0; i < questionList.size(); i++){

            if (questionList.get(i).equals("p1")){
                q.setParameter(questionList.get(i), research.getP1());
            }
            if (questionList.get(i).equals("p2")){
                q.setParameter(questionList.get(i), research.getP2());
            }
            if (questionList.get(i).equals("p3")){
                q.setParameter(questionList.get(i), research.getP3());
            }
            if (questionList.get(i).equals("p4")){
                q.setParameter(questionList.get(i), research.getP4());
            }
            if (questionList.get(i).equals("p5")){
                q.setParameter(questionList.get(i), research.getP5());
            }
            if (questionList.get(i).equals("p6")){
                q.setParameter(questionList.get(i), research.getP6());
            }
            if (questionList.get(i).equals("p7")){
                q.setParameter(questionList.get(i), research.getP7());
            }
            if (questionList.get(i).equals("p8")){
                q.setParameter(questionList.get(i), research.getP8());
            }
            if (questionList.get(i).equals("p9")){
                q.setParameter(questionList.get(i), research.getP9());
            }
            if (questionList.get(i).equals("p10")){
                q.setParameter(questionList.get(i), research.getP10());
            }
            if (questionList.get(i).equals("p11")){
                q.setParameter(questionList.get(i), research.getP11());
            }
            if (questionList.get(i).equals("p12")){
                q.setParameter(questionList.get(i), research.getP12());
            }
            if (questionList.get(i).equals("p13")){
                q.setParameter(questionList.get(i), research.getP13());
            }
            if (questionList.get(i).equals("p14")){
                q.setParameter(questionList.get(i), research.getP14());
            }
            if (questionList.get(i).equals("p15")){
                q.setParameter(questionList.get(i), research.getP15());
            }
            if (questionList.get(i).equals("p16")){
                q.setParameter(questionList.get(i), research.getP16());
            }
            if (questionList.get(i).equals("p17")){
                q.setParameter(questionList.get(i), research.getP17());
            }
            if (questionList.get(i).equals("p18")){
                q.setParameter(questionList.get(i), research.getP18());
            }
            if (questionList.get(i).equals("p19")){
                q.setParameter(questionList.get(i), research.getP19());
            }
        }

        return q.getSingleResult().toString();
    }

    //This method returns a list of researchs that is similar to research  you sent.
    public List<Research> getResearchsByExample(Research research, ArrayList<String> questionList){
        
        String query = "SELECT R FROM Research as R ";
        String condition = "WHERE";

        if (questionList.isEmpty()){
            return null;
        }

        for (int i = 0; i < questionList.size(); i++){

            query += condition + " R."+questionList.get(i)+" = :"+questionList.get(i);
            condition = " AND ";

        }

        TypedQuery<Research> q =  manager.createQuery(query, Research.class);

        for (int i = 0; i < questionList.size(); i++){
            if (questionList.get(i).equals("p1")){
                q.setParameter(questionList.get(i), research.getP1());
            }
            if (questionList.get(i).equals("p2")){
                q.setParameter(questionList.get(i), research.getP2());
            }
            if (questionList.get(i).equals("p3")){
                q.setParameter(questionList.get(i), research.getP3());
            }
            if (questionList.get(i).equals("p4")){
                q.setParameter(questionList.get(i), research.getP4());
            }
            if (questionList.get(i).equals("p5")){
                q.setParameter(questionList.get(i), research.getP5());
            }
            if (questionList.get(i).equals("p6")){
                q.setParameter(questionList.get(i), research.getP6());
            }
            if (questionList.get(i).equals("p7")){
                q.setParameter(questionList.get(i), research.getP7());
            }
            if (questionList.get(i).equals("p8")){
                q.setParameter(questionList.get(i), research.getP8());
            }
            if (questionList.get(i).equals("p9")){
                q.setParameter(questionList.get(i), research.getP9());
            }
            if (questionList.get(i).equals("p10")){
                q.setParameter(questionList.get(i), research.getP10());
            }
            if (questionList.get(i).equals("p11")){
                q.setParameter(questionList.get(i), research.getP11());
            }
            if (questionList.get(i).equals("p12")){
                q.setParameter(questionList.get(i), research.getP12());
            }
            if (questionList.get(i).equals("p13")){
                q.setParameter(questionList.get(i), research.getP13());
            }
            if (questionList.get(i).equals("p14")){
                q.setParameter(questionList.get(i), research.getP14());
            }
            if (questionList.get(i).equals("p15")){
                q.setParameter(questionList.get(i), research.getP15());
            }
            if (questionList.get(i).equals("p16")){
                q.setParameter(questionList.get(i), research.getP16());
            }
            if (questionList.get(i).equals("p17")){
                q.setParameter(questionList.get(i), research.getP17());
            }
            if (questionList.get(i).equals("p18")){
                q.setParameter(questionList.get(i), research.getP18());
            }
            if (questionList.get(i).equals("p19")){
                q.setParameter(questionList.get(i), research.getP19());
            }
        }

        return q.getResultList();
    }

    //This method returns the percentage of researchs similar to what you sent.
    public HashMap getPercentageByResearch(Research research, ArrayList<String> questionList){
        if (questionList.isEmpty()){
            return null;
        }
        Query query = manager.createQuery("SELECT COUNT(R) FROM Research as R");
        Float totalOfResearchs = Float.valueOf(query.getSingleResult().toString());
        Float countOfResearchs = Float.valueOf(getCountByResearch(research, questionList));
        Float percentage = (countOfResearchs * 100) / totalOfResearchs;

        HashMap response = new HashMap();
        response.put("total", totalOfResearchs);
        response.put("count", countOfResearchs);
        response.put("percentage", percentage);

        return response;
    }

    //This method works like the getCascadeCountByResearch method, but it returns the percentage, not the count.
    public HashMap getCascadePercentage(Research research, ArrayList<String> cascadeCountKeys){
        if (cascadeCountKeys.isEmpty()){
            return null;
        }
        HashMap cascadeCount = getCascadeCountByResearch(research, cascadeCountKeys);

        HashMap response = new HashMap();


        Float total = Float.valueOf(cascadeCount.get("total").toString());
        response.put("total", cascadeCount.get("total"));

        for (int i = 0; i < cascadeCountKeys.size(); i++){
            Float percentage = (Float.parseFloat(cascadeCount.get(cascadeCountKeys.get(i)).toString()) * 100) / total;
            response.put(cascadeCountKeys.get(i), percentage);
            total = Float.parseFloat(cascadeCount.get(cascadeCountKeys.get(i)).toString());
        }
        return response;
    }

}
