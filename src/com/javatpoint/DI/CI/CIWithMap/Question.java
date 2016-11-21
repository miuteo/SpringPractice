package com.javatpoint.DI.CI.CIWithMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ionela on 11/20/2016.
 */
public class Question {
    private int id;
    private String name;
    private Map<String,String> answers;

    public Question(int id, String name, Map<String, String> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }
    public void displayInfo(){
        System.out.println("question id:"+id);
        System.out.println("question name:"+name);
        System.out.println("Answers....");
        Set<Map.Entry<String, String>> set=answers.entrySet();
        Iterator<Map.Entry<String, String>> itr=set.iterator();
        while(itr.hasNext()){
            Map.Entry<String,String> entry=itr.next();
            System.out.println("Answer:"+entry.getKey()+" Posted By:"+entry.getValue());
        }
    }
}
