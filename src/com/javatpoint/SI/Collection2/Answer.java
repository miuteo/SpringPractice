package com.javatpoint.SI.Collection2;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Answer {
    private int id;
    private String name;
    private String by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return id+" "+name+" "+by;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }
}
