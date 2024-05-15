package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable String studentId){
       return studentService.removeStudent(studentId);
    }
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable String studentId){
        return studentService.getStudent(studentId);
    }

}
