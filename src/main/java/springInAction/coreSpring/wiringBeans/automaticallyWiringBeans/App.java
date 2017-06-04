package springInAction.coreSpring.wiringBeans.automaticallyWiringBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by Asus x556 on 27-May-17.
 */
@SpringBootApplication
public class App  implements CommandLineRunner {

    @Bean()
    @Primary
    SgtPeppers sgtPeppers(){
        return new SgtPeppers();
    }


    @Autowired
    SgtPeppers sgtPeppers;

    @Autowired()
    SgtPeppers sgtPeppers2;

    @Override
    public void run(String... strings) throws Exception{
        sgtPeppers.play();
        System.out.println(sgtPeppers);
        System.out.println(sgtPeppers2);
        System.out.println(sgtPeppers());
        System.out.println(sgtPeppers==sgtPeppers2);
    }



    public static void main(String[]args){
        SpringApplication.run(App.class,args);

    }
}
