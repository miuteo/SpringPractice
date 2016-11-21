package com.javatpoint.SI.map2;

import java.util.Map;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Question {
    private int id;
    private String name;
    private Map<Answer,User> answers;

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

    public Map<Answer, User> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Answer, User> answers) {
        this.answers = answers;
    }
    public void displayInfo(){
        System.out.println("question id: "+id);
        System.out.println("question name:"+name);
        System.out.println("Answers...");
        for(Map.Entry a : answers.entrySet()){
            System.out.println("Answer Information:");
            System.out.println(a.getKey());
            System.out.println("Posted By:");
            System.out.println(a.getValue());
        }

    }
}
