package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.dto.NewCourseDTO;

import java.util.List;

public interface CourseDAO {
    List<Course> getCourses();
    Course getCourse(int courseId);
    void addStudentToCourse(String studentId, int courseId);
    void deleteStudentFromCourse(String studentId, int courseId);
    void addCourse(NewCourseDTO newCourseDTO);
}
