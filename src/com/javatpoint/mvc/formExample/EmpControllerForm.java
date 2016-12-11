package com.javatpoint.mvc.formExample;

import com.javatpoint.mvc.crudExample.Emp;
import com.javatpoint.orm.hibernate.Employee;
import com.javatpoint.orm.hibernate.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus x556 on 10-Dec-16.
 */
@Controller
public class EmpControllerForm {
    List<Emp> list = new ArrayList<>();

    @RequestMapping("/empformMock")
    public ModelAndView showform(){
        return new ModelAndView("empform","command",new Emp());
    }
    @RequestMapping(value = "/saveMock",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Emp emp){
        list.add(emp);
        System.out.println(emp);
//        return new ModelAndView("empform","command",emp);
        return new ModelAndView("redirect:/viewempMock");
    }
    @RequestMapping("/viewempMock")
    public ModelAndView viewemp(){
        return new ModelAndView("viewemp","list",list);
    }

}
