package com.emp.service;

import com.emp.model.Employee;
import com.emp.model.Student;
import com.emp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student studUpdate(Student student, Integer studID) {
        Optional<Student> studentOptional =  studentRepository.findById(studID);
        student.setId(studID);
        return studentRepository.save(student); // Save will do save and update
    }

    public Boolean studDelete(Integer studID){
        Optional<Student> studentOptional =  studentRepository.findById(studID);
        if(studentOptional.isPresent()){
            studentRepository.deleteById(studID);
            return true;
        }
        else {
            return false;
        }
    }

    public Student findById(Integer studId) {
        Optional<Student> studentOptional =  studentRepository.findById(studId);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
