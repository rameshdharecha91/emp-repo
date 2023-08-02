package com.emp.controller;

import com.emp.model.Student;
import com.emp.response.Response;
import com.emp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/stud/save")
    public Response<Student> save(@RequestBody Student student){
        Student stud = studentService.save(student);
        Response<Student> response = new Response<>(stud,201,"CREATED");
        return response;
    }
}
