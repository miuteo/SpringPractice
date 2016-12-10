package com.javatpoint.mvc.formExample;

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
public class EmpController {
    @RequestMapping("/empform")
    public ModelAndView showform(){
        return new ModelAndView("empform","command",new Employee());
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Employee emp){
        System.out.println(emp);
//        return new ModelAndView("empform","command",emp);
        return new ModelAndView("redirect:/viewemp");
    }
    @RequestMapping("/viewemp")
    public ModelAndView viewemp(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"rahul",35000));
//        ApplicationContext context = new ClassPathXmlApplicationContext("com\\javatpoint\\orm\\hibernate\\applicationContext.xml");
//        EmployeeDao dao = (EmployeeDao) context.getBean("d");
//        List<Employee> list= dao.getEmployees();
//        list.add(new Emp(1,"rahul",35000,"S.Engineer"));
//        list.add(new Emp(2,"aditya",25000,"IT Manager"));
//        list.add(new Emp(3,"sachin",55000,"Care Taker"));

        return new ModelAndView("viewemp","list",list);
    }

}
