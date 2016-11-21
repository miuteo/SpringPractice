package com.javatpoint.DI.CI.CIWithCollection;

import java.util.List;

/**
 * Created by Ionela on 11/20/2016.
 */
public class Question {
    private int id;
    private String name;
    private List<String> answers;
    public Question(int id,String name,List<String>answers){
        this.id = id;
        this.name = name;
        this.answers = answers;
    }
    public String toString(){
        return(id +" " + name +"\nanswers are:"+answers);
    }
}
