package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.model.exception.InvalidCourseIdException;
import com.codecool.neptunus.model.exception.InvalidCourseIdException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryCourseDAO implements CourseDAO{
    private final List<Course> courses;

    private StudentDAO studentDAO;

    public MemoryCourseDAO(StudentDAO studentDAO) {
        this.courses = new ArrayList<>();
        this.studentDAO = studentDAO;
    }

// TODO Gergo
    @Override
    public List<Course> getCourses() {
        return this.courses;
    }

// TODO Reka
    @Override
    public Course getCourse(int courseId) {
        Optional<Course> course = courses.stream().filter(course1 -> course1.getCourseId() == courseId).findAny();

        if (course.isEmpty()) {
            throw new InvalidCourseIdException();
        }

        return course.get();
    }

// TODO Reka
    @Override
    public void addStudentToCourse(String studentId, int courseId) {
        Student student = studentDAO.getStudent(studentId);
        Course course = getCourse(courseId);

        course.addStudent(student);
        student.addCourse(course);
        return;
    }

// TODO Reka

    @Override
    public void deleteStudentFromCourse(String studentId, int courseId) {
        Student student = studentDAO.getStudent(studentId);
        Course course = getCourse(courseId);

        course.removeStudent(student);
        student.removeCourse(course);
        return;
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
