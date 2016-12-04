package com.javatpoint.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Asus x556 on 04-Dec-16.
 */
@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("welcomepage","message","welcome message");
    }
}
