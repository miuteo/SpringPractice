package gs.restService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Asus x556 on 14-May-17.
 */
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "greeting",method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World")String name){
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template,name));
//        System.out.println(greeting);
        return greeting;
    }
}
