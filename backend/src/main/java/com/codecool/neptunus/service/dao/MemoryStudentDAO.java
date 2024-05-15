package com.codecool.neptunus.service.dao;

import com.codecool.neptunus.model.exception.InvalidStudentIDController;
import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryStudentDAO implements StudentDAO {

    private final List<Student> students;

    public MemoryStudentDAO() {
        this.students = new ArrayList<>();
    }

    // TODO Melani
    @Override
    public String addStudent(Student newStudent) {
        students.add(newStudent);
        return newStudent.getStudentId();
    }

    // TODO Melani
    @Override
    public String removeStudent(String studentId) {
        Optional<Student> searchedStudent = students.stream().filter(student -> student.checkStudentId(studentId)).findFirst();
        if(searchedStudent.isPresent()){
            students.remove(searchedStudent.get());
            return studentId;
        } else {
            throw new InvalidStudentIDController();
        }
    }

    // TODO Melani
    @Override
    public Student getStudent(String studentId) {
        Optional<Student> searchedStudent = students.stream().filter(student -> student.checkStudentId(studentId)).findFirst();
        if (searchedStudent.isEmpty()) {
            throw new InvalidStudentIDController();
        }
        return searchedStudent.get();
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
