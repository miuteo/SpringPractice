package com.javatpoint.DI.CI.inheritingBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\DI\\CI\\applicationContext.xml");
        Employee employee1 = (Employee) context.getBean("employeeInherit");
        employee1.show();

        Employee employee2 = (Employee) context.getBean("employeeInherit2");
        employee2.show();
    }
}
