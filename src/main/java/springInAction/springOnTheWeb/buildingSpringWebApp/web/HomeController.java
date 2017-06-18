package springInAction.springOnTheWeb.buildingSpringWebApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Asus x556 on 18-Jun-17.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
