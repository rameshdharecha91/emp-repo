package com.emp.controller;

import com.emp.response.Response;
import com.emp.model.Employee;
import com.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
This is repository layer
Controller manage all request and response api

* */
@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/emp/save")
   public Response<Employee> save(@RequestBody Employee employee){
        Employee emp = employeeService.save(employee);
        Response<Employee> response = new Response<>(emp,201,"CREATED");
        return response;
    }

    @GetMapping(value = "/emp/get-all")
    public Response<List<Employee>> getAll(){
        List<Employee> listOfEmployee = employeeService.findAll();

        Response<List<Employee>> response;

        if(ObjectUtils.isEmpty(listOfEmployee)){
            response  = new Response<>(listOfEmployee,204,"NOT-FOUND");
        }
        else {
            response  = new Response<>(listOfEmployee,200,"OK");
        }
        return response;
    }

    @DeleteMapping(value = "/emp/del/{empId}")
    public Response<Boolean> empDel(@PathVariable("empId") Integer empID){
        Boolean result = employeeService.empDelete(empID);
        Response<Boolean> response;
        if(result){
             response = new Response<>(true,200,"OK");
        }
        else{
            response = new Response<>(false,204,"NOT-FOUND");
        }
        return response;
    }
    @PutMapping(value = "/emp/edit/{empId}")
    public Response<Employee> empUpdate(@RequestBody Employee employee,@PathVariable("empId") Integer empID){
        Employee emp = employeeService.empUpdate(employee,empID);
        Response<Employee> response;
        if(ObjectUtils.isEmpty(emp)){
           response = new Response<>(null,204,"NOT-FOUND");
        }else{
            response = new Response<>(emp,201,"OK");
        }
        return response;
    }
}
