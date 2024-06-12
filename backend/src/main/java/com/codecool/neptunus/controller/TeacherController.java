package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Teacher;
import com.codecool.neptunus.model.dto.newDTO.NewTeacherDTO;
import com.codecool.neptunus.model.dto.TeacherDTO;
import com.codecool.neptunus.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacher(@PathVariable long id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCourses(@PathVariable long id) {
        return teacherService.getCourses(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable long id) {
        teacherService.deleteTeacher(id);
    }
}
