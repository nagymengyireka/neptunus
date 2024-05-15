package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public void addCourse(@RequestBody NewCourseDTO newCourseDTO) {
        courseService.addCourse(newCourseDTO);
        return;
    }
}
