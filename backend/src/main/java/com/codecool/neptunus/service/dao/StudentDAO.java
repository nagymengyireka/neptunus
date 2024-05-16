package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;

import java.util.List;

public interface StudentDAO {
    String addStudent(Student student);
    String removeStudent(String studentId);
    Student getStudent(String studentId);
    List<Course> getCoursesForStudent(String studentId);
}
