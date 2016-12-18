package com.javatpoint.remoting.httpInvoker;

import com.javatpoint.remoting.rmi.Calculation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Asus x556 on 18-Dec-16.
 */
public class Client {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\remoting\\httpInvoker\\client-beans.xml");
        Calculation calculation = (Calculation)context.getBean("httpCalculationBean");
        System.out.println(calculation.cube(5));
    }
}