package gs.buildingFirstMaven;
import gs.consumingRest.ApplicationWithSpringBoot;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import org.joda.time.LocalTime;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus x556 on 06-May-17.
 */
public class HelloWorld {

    public static void main(String[] args){
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }

    static <T>void showMethodsArguments(Class<T> tClass){
        Method[] declaredMethods = tClass.getDeclaredMethods();
        LocalVariableTableParameterNameDiscoverer lvtpnd = new LocalVariableTableParameterNameDiscoverer();
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod+":");

            String[] params =lvtpnd.getParameterNames(declaredMethod);
            if(params!=null){
                for(String s:params){
                    System.out.print(s+", ");
                }
                System.out.println();
            }
        }


    }

}
