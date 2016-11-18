package com.javatpoint1;

/**
 * Created by Ionela on 11/18/2016.
 */
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void displayInfo(){
        System.out.println("Student name: "+name);
    }
}

