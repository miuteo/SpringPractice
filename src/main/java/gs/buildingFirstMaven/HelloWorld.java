package gs.buildingFirstMaven;
import org.joda.time.LocalTime;

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
}
