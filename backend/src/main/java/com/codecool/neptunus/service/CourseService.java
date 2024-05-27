package com.codecool.neptunus.service;

import com.codecool.neptunus.controller.advice.GeneralControllerAdvice;
import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.model.dto.CourseDTO;
import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.repository.CourseRepository;
import com.codecool.neptunus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Set<Student> getStudentsForCourse(Long courseId){
        return courseRepository.getStudents(courseId);
    }

    public CourseDTO getCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return new CourseDTO(course.get().getId(), course.get().getName(), course.get().getTeacherName());
        }
        throw new IllegalArgumentException("Invalid Course ID!");
    }

    public void addCourse(NewCourseDTO newCourseDTO) {
        Course course = new Course();
        course.setName(newCourseDTO.name());
        course.setTeacherName(newCourseDTO.teacherName());
        courseRepository.save(course);
    }

    public void addStudentToCourse(Long studentId, Long courseId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent() && optionalStudent.isPresent()) {
            Course course = optionalCourse.get();
            Student student = optionalStudent.get();
            course.addStudent(student);
            courseRepository.save(course);
        } else {
            throw new IllegalArgumentException("Invalid student or course ID");
        }
    }

    public void deleteStudentFromCourse(Long studentId, Long courseId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent() && optionalStudent.isPresent()) {
            Course course = optionalCourse.get();
            Student student = optionalStudent.get();
            course.removeStudent(student);
            courseRepository.save(course);
        } else {
            throw new IllegalArgumentException("Invalid student or course ID");
        }
    }
}
