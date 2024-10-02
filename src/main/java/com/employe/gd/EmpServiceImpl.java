package com.employe.gd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        // Convert DTO to entity
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        
        // Save the employee entity to the database
        employeeRepository.save(employeeEntity);

        return "Employee created successfully";
    }

    @Override
    public List<Employee> readEmployee() {
        // Fetch all employee entities from the database
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        
        // Convert entities to DTOs
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp =employeeRepository.findById(id).get();
       employeeRepository.delete(emp);
       return true;
    }

   @Override
   public String updateEmployee(Long id, Employee employee) {
      EmployeeEntity existingEmpployee=employeeRepository.findById(id).get();

      existingEmpployee.setEmail(employee.getEmail());
      existingEmpployee.setName(employee.getName());
      existingEmpployee.setPhone(employee.getPhone());

      employeeRepository.save(existingEmpployee);
      return "update succesfylly";
   }
}
