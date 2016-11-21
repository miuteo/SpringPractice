package com.javatpoint.DI.CIWithMap2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\DI\\applicationContext.xml");
        Question question = (Question) context.getBean("questionMap2");
        question.displayInfo();
    }
}
