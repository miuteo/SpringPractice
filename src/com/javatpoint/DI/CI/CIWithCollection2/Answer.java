package com.javatpoint.DI.CI.CIWithCollection2;

/**
 * Created by Ionela on 11/20/2016.
 */
public class Answer {
    private int id;
    private String name;
    private String by;

    public Answer(int id, String name, String by) {
        this.id = id;
        this.name = name;
        this.by = by;
    }

    public String toString(){
        return id+" "+name+" "+by;
    }
}