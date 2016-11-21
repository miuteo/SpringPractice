package com.javatpoint.SI.dependentObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\SI\\applicationContext.xml");
        Employee employee = (Employee) context.getBean("employee2");
        employee.displayInfo();
    }
}
