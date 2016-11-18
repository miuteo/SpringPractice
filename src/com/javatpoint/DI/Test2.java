package com.javatpoint.DI;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by Ionela on 11/18/2016.
 */
public class Test2 {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\\\javatpoint\\\\DI\\\\applicationContext.xml");

        Employee s1 = (Employee) context.getBean("employee");
        s1.show();

        Employee s2 = (Employee) context.getBean("employeeID");
        s2.show();

        Employee s3 = (Employee) context.getBean("employeeTypeDefault");
        s3.show();

        Employee s4 = (Employee) context.getBean("employeeBothConstrArg");
        s4.show();

        Employee s5 = (Employee) context.getBean("employeeWithAddress");
        s5.show();
    }
}
