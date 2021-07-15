package com.techcushy.project_simple.controller;

import com.techcushy.project_simple.model.Employee;
import com.techcushy.project_simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getEmployee(Model model){
       model.addAttribute("listEmployee", employeeService.getAllEmployee());
       return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showEmployeeForm(Model model){
            Employee employee =  new Employee();
           model.addAttribute("employee",employee);
           return "new_employee";

    }

    //handle the form data use @ModelAttribute
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFromForUpdate/{id}")
    public String showFromForUpdate(@PathVariable(value ="id") long id, Model model){

       Employee employee=  employeeService.getEmployeeById(id);
       model.addAttribute("employee",employee);
       return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value="id")long id){
          this.employeeService.deleteEmployee(id);
          return "redirect:/";
    }
}
