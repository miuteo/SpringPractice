package com.javatpoint.orm.hibernate;

import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus x556 on 24-Nov-16.
 */
public class EmployeeDao {
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void saveEmployee(Employee e){
        template.save(e);
    }
    public void updateEmployee(Employee e){
        template.update(e);
    }
    public void deleteEmployee(Employee e){
        template.delete(e);
    }
    public Employee getById(int id){
        Employee e =(Employee) template.get(Employee.class,id);
        return  e;
    }
    public List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list=template.loadAll(Employee.class);
        return list;
    }

}
