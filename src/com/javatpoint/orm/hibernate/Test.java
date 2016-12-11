package com.javatpoint.orm.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus x556 on 24-Nov-16.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\orm\\hibernate\\applicationContext.xml");
        EmployeeDao dao = (EmployeeDao) context.getBean("d");
        Employee employee = new Employee(4,"Teo Miu",1500);
//        dao.saveEmployee(employee);

        List<Employee> list = dao.getEmployees();
        for(Employee e:list)
            System.out.println(e);


        System.out.println(dao.getById(3));

        employee.setSalary(2500);
        dao.updateEmployee(employee);
        employee =dao.getById(3);
        System.out.println(employee);
        dao.deleteEmployee(employee);

        list = dao.getEmployees();
        for(Employee e:list)
            System.out.println(e);
    }
}
