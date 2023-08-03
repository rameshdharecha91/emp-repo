package com.emp.controller;

import com.emp.model.Employee;
import com.emp.model.Student;
import com.emp.response.Response;
import com.emp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/stud/get-all")
        public Response<List<Student>> getAll()
        {
            List<Student> listOfStudent = studentService.findAll();
            Response<List<Student>> response;

            if(ObjectUtils.isEmpty(listOfStudent))
            {
                response = new Response<>(listOfStudent,204,"Not Found");
            }else{
                response = new Response<>(listOfStudent,200,"Success");

            }
            return response;
        }

    @PutMapping(value = "/stud/edit/{studId}")
    public Response<Student> studUpdate(@RequestBody Student student,@PathVariable("studId") Integer studID){
        Student stud = studentService.studUpdate(student,studID);
        Response<Student> response;
        if(ObjectUtils.isEmpty(stud)){
            response = new Response<>(null,204,"NOT-FOUND");
        }else{
            response = new Response<>(stud,201,"OK");
        }
        return response;
    }

    @DeleteMapping(value = "/stud/del/{studId}")
    public Response<Boolean> studDel(@PathVariable("studId") Integer studID){
        Boolean result = studentService.studDelete(studID);
        Response<Boolean> response;
        if(result){
            response = new Response<>(true,200,"OK");
        }
        else{
            response = new Response<>(false,204,"NOT-FOUND");
        }
        return response;
    }

    @GetMapping(value = "/stud/{studId}")
    public Response<Student> getStud(@PathVariable("studId") Integer studId){
        Student emp = studentService.findById(studId);
        Response<Student> response;
        if(ObjectUtils.isEmpty(emp)){
            response = new Response<>(emp,204,"NOT-FOUND");
        }else{
            response = new Response<>(emp,201,"OK");
        }
        return response;
    }
}
