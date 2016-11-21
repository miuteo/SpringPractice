package com.javatpoint.DI.factoryMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\DI\\factoryMethod\\contextApp.xml");
//        A a =(A) context.getBean("a");
//        a.msg();

        Printable printable = context.getBean("p",Printable.class);
        printable.print();
    }
}
