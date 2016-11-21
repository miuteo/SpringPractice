package com.javatpoint.SI.Collection;

import java.util.List;
import java.util.Set;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Question {
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }

    private String name;
    private Set<String> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void displayInfo(){
        System.out.println(id+" "+name);
        System.out.println("answers are:");
        for(String s:answers){
            System.out.println(s);
        }
    }
}
