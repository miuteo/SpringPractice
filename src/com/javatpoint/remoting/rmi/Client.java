package com.javatpoint.remoting.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Asus x556 on 17-Dec-16.
 */
public class Client {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\remoting\\rmi\\client-beans.xml");
        Calculation calculation = (Calculation) context.getBean("calculationBean");
        System.out.println(calculation.cube(7));
    }
}
