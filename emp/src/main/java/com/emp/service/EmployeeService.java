package com.emp.service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
This is service layer
Business Logic :
To Do:
1)Create employee data
2)Read employee data
3)Update employee data
4)Delete employee data
**/
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        Employee emp = employeeRepository.save(employee);
        return emp;
    }

    public List<Employee> findAll() {
       return employeeRepository.findAll();
    }

    public Boolean empDelete(Integer empID){
       Optional<Employee> employeeOptional =  employeeRepository.findById(empID);
       if(employeeOptional.isPresent()){
           employeeRepository.deleteById(empID);
           return true;
       }
       else {
             return false;
       }
    }

    public Employee empUpdate(Employee employee, Integer empID) {
        Optional<Employee> employeeOptional =  employeeRepository.findById(empID);
        if(employeeOptional.isPresent()){
            employee.setId(empID);
            return employeeRepository.save(employee); // Save will do save and update
        }
        return null;
    }
}
