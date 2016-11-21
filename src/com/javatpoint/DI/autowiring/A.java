package com.javatpoint.DI.autowiring;

/**
 * Created by Ionela on 11/21/2016.
 */
public class A {
    B ba;
    A(){
        System.out.println("a is created");
    }

    public B getB() {
        return ba;
    }

    public void setB(B b) {
        this.ba = b;
    }
    void print(){
        System.out.println("hello a");
    }
    void display(){
        print();
        ba.print();
    }

}
