package com.javatpoint.mvc.formExample;

import com.javatpoint.orm.hibernate.Employee;
import com.javatpoint.orm.hibernate.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Asus x556 on 10-Dec-16.
 */
public class Test {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\orm\\hibernate\\applicationContext.xml");
        EmployeeDao dao = (EmployeeDao) context.getBean("d");
        List<Employee> list= dao.getEmployees();
        System.out.println(list);
    }
}
