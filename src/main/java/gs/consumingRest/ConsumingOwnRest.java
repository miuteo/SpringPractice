package gs.consumingRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by teodor.miu on 18-May-17.
 */
public class ConsumingOwnRest {
    private static final Logger logger =  LoggerFactory.getLogger(ConsumingOwnRest.class);
    public static void main(String[]args){
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://localhost:8080/getQoute",Quote.class);
        logger.debug(quote+"");
    }
}
