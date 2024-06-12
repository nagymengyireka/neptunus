package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.dto.newDTO.NewCourseDTO;
import com.codecool.neptunus.repository.CourseRepository;
import com.codecool.neptunus.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseService courseService;

    private CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
    private StudentRepository studentRepository = Mockito.mock(StudentRepository.class);

    @BeforeEach
    void setup(){
        this.courseService = new CourseService(courseRepository, studentRepository);
    }

    @Test
    void addCourseWhenCourseDTOReceivedSavesCourse() {
        NewCourseDTO newCourseDTO = new NewCourseDTO("Java","Bela");
        Course course = new Course();
        course.setName("Java");
        course.setTeacherName("Bela");

        courseService.addCourse(newCourseDTO);
        Mockito.verify(courseRepository).save(course);
    }
}