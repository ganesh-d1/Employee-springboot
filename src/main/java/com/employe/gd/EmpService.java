package com.employe.gd;

import java.util.List;

public interface EmpService {
     String createEmployee(Employee employee);
     List<Employee> readEmployee();
     boolean deleteEmployee(Long id);

     String updateEmployee(Long id,Employee employee);

    

  
     
}
