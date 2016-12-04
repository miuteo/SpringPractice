package com.javatpoint.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
        String message = "HELLO SPRING MVC HOW R U";
        return new ModelAndView("hellopage", "message", message);
    }
}