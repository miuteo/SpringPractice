package com.javatpoint.DI.CI.CIWithCollection2;

import java.util.List;

/**
 * Created by Ionela on 11/20/2016.
 */
public class Question {
    private int id;
    private String name;
    private List<Answer> answers;
    public Question(int id,String name,List<Answer>answers){
        this.id = id;
        this.name = name;
        this.answers = answers;
    }
    public String toString(){
        return(id +" " + name +"\nanswers are:"+answers);
    }
}
