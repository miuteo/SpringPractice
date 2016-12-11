package com.javatpoint.mvc.crudExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Asus x556 on 11-Dec-16.
 */
@Controller
public class EmpController {
    @Autowired
    EmpDao dao;
    @RequestMapping("/empform2")
    public ModelAndView showForm(){
        return new ModelAndView("empform2","command",new Emp());
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(Emp emp){
        dao.save(emp);
        return new ModelAndView("redirect:/viewemp2");
    }

    @RequestMapping("/viewemp2")
    public ModelAndView viewemp(){
        List<Emp> list = dao.getEmployees();
        return new ModelAndView("viewemp2","list",list);
    }

    @RequestMapping(value="/editemp/{id}")
    public ModelAndView edit(@PathVariable int id){
        Emp emp=dao.getEmpById(id);
        return new ModelAndView("empeditform","command",emp);
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
        dao.update(emp);
        return new ModelAndView("redirect:/viewemp2");
    }
    @RequestMapping(value="/deleteemp/{id}",method=RequestMethod.POST)
    public ModelAndView delete(@PathVariable int id){
        dao.delete(id);
        return new ModelAndView("redirect:/viewemp2");
    }

}
