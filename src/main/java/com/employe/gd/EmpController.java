package com.employe.gd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("http://localhost:3000")
public class EmpController {
     @Autowired
    EmpService empservice;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return empservice.readEmployee();
    }

    
    @GetMapping("/employees/{id}")
    public List<Employee> getEmployeesById() {
        return empservice.readEmployee();
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
      return empservice.createEmployee(employee);

       }
       @DeleteMapping("employees/{id}")
       public String deleteEmployee(@PathVariable Long id){
        if(empservice.deleteEmployee(id))
         return "delete";
        return "not found";
       }

       @PutMapping("employees/{id}")
       public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
           
           
           return empservice.updateEmployee(id, employee) ;
       }

    
}