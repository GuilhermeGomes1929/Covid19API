package br.com.covid19.repository;

import br.com.covid19.model.Research;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRepository {

    private final EntityManager manager;

    public CustomRepository(EntityManager manager) {
        this.manager = manager;
    }

    public List<Research> find(List<String> strings, Research research){

        String query = "SELECT R FROM Research as R ";
        String condition = "WHERE";

        for (int i = 0; i < strings.size(); i++){

            query += condition + " R."+strings.get(i)+" = :"+strings.get(i);
            condition = " AND ";

        }

        var q =  manager.createQuery(query, Research.class);

        for (int i = 0; i < strings.size(); i++){
            if (strings.get(i).equals("p1")){
                q.setParameter("p1", research.getP1());
            }
            if (strings.get(i).equals("p2")){
                q.setParameter("p2", research.getP2());
            }
            if (strings.get(i).equals("p3")){
                q.setParameter("p3", research.getP3());
            }
            if (strings.get(i).equals("p4")){
                q.setParameter("p4", research.getP4());
            }
            if (strings.get(i).equals("p5")){
                q.setParameter("p5", research.getP5());
            }
            if (strings.get(i).equals("p6")){
                q.setParameter("p6", research.getP6());
            }
            if (strings.get(i).equals("p7")){
                q.setParameter("p7", research.getP7());
            }
            if (strings.get(i).equals("p8")){
                q.setParameter("p8", research.getP8());
            }
            if (strings.get(i).equals("p9")){
                q.setParameter("p9", research.getP9());
            }
            if (strings.get(i).equals("p10")){
                q.setParameter("p10", research.getP10());
            }
            if (strings.get(i).equals("p11")){
                q.setParameter("p11", research.getP11());
            }
            if (strings.get(i).equals("p12")){
                q.setParameter("p12", research.getP12());
            }
            if (strings.get(i).equals("p13")){
                q.setParameter("p13", research.getP13());
            }
            if (strings.get(i).equals("p14")){
                q.setParameter("p14", research.getP14());
            }
            if (strings.get(i).equals("p15")){
                q.setParameter("p15", research.getP15());
            }
            if (strings.get(i).equals("p16")){
                q.setParameter("p16", research.getP16());
            }
            if (strings.get(i).equals("p17")){
                q.setParameter("p17", research.getP17());
            }
            if (strings.get(i).equals("p18")){
                q.setParameter("p18", research.getP18());
            }
            if (strings.get(i).equals("p19")){
                q.setParameter("p19", research.getP19());
            }
        }

        return q.getResultList();
    }

}
