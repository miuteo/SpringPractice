package com.javatpoint.DI.factoryMethod;

/**
 * Created by Ionela on 11/21/2016.
 */
public class A {
    private static final A a = new A();
    private A(){
        System.out.println("private constructor");
    }
    public static A getA(){
        System.out.println("factory method");
        return a;
    }
    public void msg(){
        System.out.println("hello user");
    }
}
