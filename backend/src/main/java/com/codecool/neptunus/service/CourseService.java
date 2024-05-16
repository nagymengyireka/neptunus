package com.codecool.neptunus.service;

import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.service.dao.CourseDAO;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void addCourse(NewCourseDTO newCourseDTO) {
        courseDAO.addCourse(newCourseDTO);
        return;
    }
}
