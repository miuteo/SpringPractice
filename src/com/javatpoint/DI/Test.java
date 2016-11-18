package com.javatpoint.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/18/2016.
 */
public class Test {
    public static void main(String[]args){
//        Resource resource = new ClassPathResource("com\\javatpoint\\DI\\applicationContext.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);

        ApplicationContext context = new ClassPathXmlApplicationContext("com\\\\javatpoint\\\\DI\\\\applicationContext.xml");

//        Student student = (Student) factory.getBean("studentbean");
        Student student = (Student) context.getBean("studentbean");
        student.displayInfo();
    }
}
