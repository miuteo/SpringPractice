package gs.consumingRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Asus x556 on 16-May-17.
 */
@SpringBootApplication
public class ApplicationWithSpringBoot {
    private static final Logger log = LoggerFactory.getLogger(ApplicationWithSpringBoot.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate)throws Exception{
        return args ->{
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };

    }
    public static void main(String[]args){
        SpringApplication.run(ApplicationWithSpringBoot.class);
    }
}
