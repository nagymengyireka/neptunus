package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.dto.NewCourseDTO;
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
    public void addCourse(NewCourseDTO newCourseDTO) {
        int newCourseId;

        if (courses.isEmpty()) {
            newCourseId = 1;
        } else {
            newCourseId = courses.stream()
                    .mapToInt(Course::getCourseId)
                    .max().getAsInt() + 1;
        }

        Course newCourse = new Course(newCourseDTO.name(), newCourseId, newCourseDTO.teacherName());
        courses.add(newCourse);

        //System.out.println(courses.getLast());
        return;
    }
}
