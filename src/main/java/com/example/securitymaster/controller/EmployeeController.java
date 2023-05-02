package com.example.securitymaster.controller;

import com.example.securitymaster.dao.EmployeeDao;
import com.example.securitymaster.ds.Employee;
import com.example.securitymaster.security.annonation.customer.CustomersCreate;
import com.example.securitymaster.security.annonation.employee.EmployeesCreate;
import com.example.securitymaster.security.annonation.employee.EmployeesDelete;
import com.example.securitymaster.security.annonation.employee.EmployeesRead;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;


    @GetMapping("/employees")
    @EmployeesRead
    public ModelAndView listAllEmployee(){
        return new ModelAndView("employees","employees",employeeDao.findAll());
    }
    @GetMapping("/employee-form")
    @EmployeesCreate
    public String employeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employeeform";

    }

    @PostMapping("/employee-form")
    @EmployeesCreate
    public String EmployeeCreate(@Valid Employee employee, BindingResult result){
      if (result.hasErrors()){
          return "employeeform";
      }
       employeeDao.save(employee);
        return "redirect:employee/employees";
      }
      @GetMapping("/delete")
      @EmployeesDelete
      public String deleteEmp(@RequestParam int id){
        employeeDao.deleteById(id);
        return "redirect:/employee/employees";
      }
    }

