package com.javatpoint.DI.factoryMethod;


/**
 * Created by Ionela on 11/21/2016.
 */
public class PrintableFactory {
    public static Printable getPrintable(){
//        return new B2();
        return new A2();//return any one instance, either A or B
    }
}
