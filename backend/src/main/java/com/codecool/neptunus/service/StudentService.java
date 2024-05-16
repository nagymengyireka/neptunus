package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.service.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.codecool.neptunus.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Course> getCoursesForStudent(String studentId){
        return studentDAO.getCoursesForStudent(studentId);
    }

    public String addStudent(Student student){
        return studentDAO.addStudent(student);
    }

    public String removeStudent(String studentId){
        return studentDAO.removeStudent(studentId);
    }
    public Student getStudent(String studentId){
        return studentDAO.getStudent(studentId);
    }


}
