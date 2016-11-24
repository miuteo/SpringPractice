package com.javatpoint.DI.CI.CIWithMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/20/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\DI\\CI\\applicationContext.xml");
        Question question = (Question) context.getBean("questionMap");
        question.displayInfo();
    }
}