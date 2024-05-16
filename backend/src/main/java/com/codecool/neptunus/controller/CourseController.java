package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.service.CourseService;
import org.springframework.web.bind.annotation.*;
import com.codecool.neptunus.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping()
    public void addCourse(@RequestBody NewCourseDTO newCourseDTO) {
        courseService.addCourse(newCourseDTO);
        return;
    }

    @GetMapping("/")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{courseId}/students")
    public List<Student> getStudentsForCourse(@PathVariable int courseId){
        return courseService.getStudentsForCourse(courseId);
    }
    @PostMapping("/{courseId}/students/{studentId}")
    public void addStudentToCourse(@PathVariable String studentId, @PathVariable int courseId) {
        courseService.addStudentToCourse(studentId, courseId);
        return;
    }

    @DeleteMapping("/{courseId}/students/{studentId}")
    public void deleteStudentToCourse(@PathVariable String studentId, @PathVariable int courseId) {
        courseService.deleteStudentFromCourse(studentId, courseId);
        return;
    }
}
