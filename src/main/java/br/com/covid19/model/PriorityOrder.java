package br.com.covid19.model;

import java.util.ArrayList;

public class PriorityOrder {

    private ArrayList<String> priority;
    private Research research;

    public PriorityOrder() {
    }

    public PriorityOrder(ArrayList<String> priority, Research research) {
        this.priority = priority;
        this.research = research;
    }

    public ArrayList<String> getPriority() {
        return priority;
    }

    public void setPriority(ArrayList<String> priority) {
        this.priority = priority;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }
}
