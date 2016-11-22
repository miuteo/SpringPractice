package com.javatpoint.jdbc.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ionela on 11/22/2016.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\jdbc\\template\\applicationContext.xml");
        EmployeeDao employeeDao = context.getBean("edao",EmployeeDao.class);
        int rez = employeeDao.saveEmployee(new Employee(1,"Teo",1000));
        System.out.println(rez);
    }
}
