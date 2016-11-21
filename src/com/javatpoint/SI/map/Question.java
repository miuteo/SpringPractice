package com.javatpoint.SI.map;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Question {
    private int id;
    private String name;
    private Map<String,String> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }
    public void displayInfo(){
        System.out.println("question id:"+id);
        System.out.println("question name:"+name);
        System.out.println("Answers...");
        for(Map.Entry e : answers.entrySet()){
            System.out.println("Answer:"+e.getKey()+" Posted By: "+e.getValue());
        }
    }
}
