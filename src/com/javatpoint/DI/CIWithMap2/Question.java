package com.javatpoint.DI.CIWithMap2;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Question {
    private int id;
    private String name;
    private Map<Answer,User> answer;
    public Question(int id,String name, Map<Answer,User> answers){
        this.id = id;
        this.name = name;
        this.answer = answers;
    }

    public void displayInfo(){
        System.out.println("question id:"+id);
        System.out.println("question name:"+name);
        System.out.println("Answers...");

        for(Map.Entry i : answer.entrySet()){
            System.out.println("Answer Information:");
            System.out.println(i.getKey());
            System.out.println("Posted By:");
            System.out.println(i.getValue());

        }
    }
}
