package com.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.springboot.thymeleaf.model.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    private List<Employee> theEmployees;

    @PostConstruct
    public void loadData(){
        Employee emp1 = new Employee(1, "test", "1", "teste@" );
        Employee emp2 = new Employee(2, "test", "2", "teste@" );
        Employee emp3 = new Employee(3, "test", "3", "teste@" );

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}