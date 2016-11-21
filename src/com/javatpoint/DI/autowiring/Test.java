package com.javatpoint.DI.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\DI\\autowiring\\applicationContext.xml");
        A a = context.getBean("a",A.class);
        a.display();
    }
}
