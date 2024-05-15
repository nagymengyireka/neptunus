package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void removeStudent(String studentId);
    Student getStudent(String studentId);
    List<Student> getStudents(int courseId);
    List<Course> getCourses(String studentId);
}
