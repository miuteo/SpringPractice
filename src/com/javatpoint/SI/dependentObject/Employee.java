package com.javatpoint.SI.dependentObject;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Employee {
    private int id;
    private String name;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    void displayInfo(){
        System.out.println(id+" "+name+"\n"+address);
    }
}
