package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.SpitterRepository;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.Spittle;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.SpittleRepository;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Asus x556 on 06-Jun-17.
 */
@SpringBootApplication
public class App {

    @Bean
    CommandLineRunner init(SpittleRepository spittleRepository, SpitterRepository spitterRepository){
//        String message,Date time,Double longitude,Double latitude
        return evt -> Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        message ->{
                            Double longitude = Math.random()*180*(Math.random()%2==0?1:-1);
                            Double latitude = Math.random()*180*(Math.random()%2==0?1:-1);
                            Spittle account = spittleRepository.save( new Spittle(message,new Date(),longitude,latitude));
                        }
                );
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}