package com.javatpoint.remoting.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Asus x556 on 17-Dec-16.
 */
public class Host {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\remoting\\rmi\\appcontext.xml");
        System.out.println("Waiting for requests");
    }
}
