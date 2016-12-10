package com.javatpoint.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus x556 on 04-Dec-16.
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/helloWorld")
    public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response){
       String name = request.getParameter("name");
       String password = request.getParameter("password");
        if("admin".equals(name) && "admin".equals(password)){
            return new ModelAndView("helloWorldPage","message","Hello "+name);
        }
        return new ModelAndView("errorPage","message","Sorry,username and password is incorect");
    }
}
