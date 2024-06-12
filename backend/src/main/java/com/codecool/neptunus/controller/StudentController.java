package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.dto.CourseDTO;
import com.codecool.neptunus.model.dto.newDTO.NewStudentDTO;
import com.codecool.neptunus.model.dto.StudentDTO;
import com.codecool.neptunus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDTO> getCoursesForStudent(@PathVariable Long studentId){
        return studentService.getCoursesForStudent(studentId);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
       studentService.removeStudent(studentId);
    }
    @GetMapping("/{studentId}")
    public StudentDTO getStudentById(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
    }

}
