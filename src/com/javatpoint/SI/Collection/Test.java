package com.javatpoint.SI.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\SI\\applicationContext.xml");
        Question question = (Question) context.getBean("question");
        question.displayInfo();
    }
}
