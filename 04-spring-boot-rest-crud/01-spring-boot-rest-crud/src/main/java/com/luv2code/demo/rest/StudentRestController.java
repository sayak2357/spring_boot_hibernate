package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Kim","Woo"));
        theStudents.add(new Student("Sayak","Chowdhury"));
        theStudents.add(new Student("Mainak","Bhattacharya"));

    }
    // define end point '/students' to - return list of student
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define end point '/students/{studentId}' to - return single student with given id
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        // check studentId against list size
        if(studentId<0 || studentId>=theStudents.size())
            throw new StudentNotFoundException("Student id not found - "+studentId);
        return theStudents.get(studentId);
    }




}
