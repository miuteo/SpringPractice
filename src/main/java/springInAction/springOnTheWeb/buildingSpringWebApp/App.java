package springInAction.springOnTheWeb.buildingSpringWebApp;

import gs.servingWebContent.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tutorials.bookmarks.Account;
import tutorials.bookmarks.AccountRepository;
import tutorials.bookmarks.Bookmark;
import tutorials.bookmarks.BookmarkRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Created by Asus x556 on 06-Jun-17.
 */
@SpringBootApplication
public class App {

    @Bean
    CommandLineRunner init(SpittleRepository repository){
//        String message,Date time,Double longitude,Double latitude
        return evt -> Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        message ->{
                            Double longitude = Math.random()*180*(Math.random()%2==0?1:-1);
                            Double latitude = Math.random()*180*(Math.random()%2==0?1:-1);
                            Spittle account = repository.save( new Spittle(message,new Date(),longitude,latitude));
                        }
                );
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}