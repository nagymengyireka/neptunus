package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

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

    @PostMapping("/{courseId}/students/{studentId}")
    public void addStudentToCourse(@PathVariable String studentId, @PathVariable int courseId) {
        courseService.addStudentToCourse(studentId, courseId);
        return;
    }
}
