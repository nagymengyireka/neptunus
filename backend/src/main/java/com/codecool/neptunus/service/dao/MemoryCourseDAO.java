package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryCourseDAO implements CourseDAO{
    private final List<Course> courses;

    public MemoryCourseDAO() {
        this.courses = new ArrayList<>();
    }

// TODO Gergo
    @Override
    public List<Course> getCourses() {
        return this.courses;
    }

// TODO Reka
    @Override
    public Course getCourse(int courseId) {
        return null;
    }

// TODO Reka
    @Override
    public void addStudentToCourse(String studentId, int courseId) {

    }

// TODO Reka

    @Override
    public void deleteStudentFromCourse(String studentId, int courseId) {

    }

// TODO Reka

    @Override
    public void addCourse(Course course) {
    }

    @Override
    public List<Student> getStudentsOfCourse(int courseId) {
        return courses.stream()
                .filter(course -> course.checkCourseId(courseId))
                .flatMap(course -> course.getStudents().stream())
                .toList();
    }
}
