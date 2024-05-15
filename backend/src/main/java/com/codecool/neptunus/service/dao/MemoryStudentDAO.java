package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MemoryStudentDAO implements StudentDAO {

    private final List<Student> students;

    public MemoryStudentDAO() {
        this.students = new ArrayList<>();
    }

// TODO Melani
    @Override
    public void addStudent(Student student) {

    }
// TODO Melani
    @Override
    public void removeStudent(String studentId) {

    }
// TODO Melani
    @Override
    public Student getStudent(String studentId) {
        return null;
    }

// TODO Gergo
    @Override
    public List<Student> getStudents(int courseId) {
        return List.of();
    }

// TODO Gergo
    @Override
    public List<Course> getCourses(String studentId) {
        return List.of();
    }
}
