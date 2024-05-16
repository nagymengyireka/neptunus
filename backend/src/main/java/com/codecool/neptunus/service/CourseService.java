package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.service.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.codecool.neptunus.model.dto.NewCourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public List<Course> getCourses(){
        return courseDAO.getCourses();
    }

    public List<Student> getStudentsForCourse(int courseId){
        return courseDAO.getStudentsOfCourse(courseId);
    }

    public Course getCourse(int courseId) {
        return courseDAO.getCourse(courseId);
    }

    public void addCourse(NewCourseDTO newCourseDTO) {
        courseDAO.addCourse(newCourseDTO);
        return;
    }

    public void addStudentToCourse(String studentId, int courseId) {
        courseDAO.addStudentToCourse(studentId, courseId);
    }

    public void deleteStudentFromCourse(String studentId, int courseId) {
        courseDAO.deleteStudentFromCourse(studentId, courseId);
    }
}
