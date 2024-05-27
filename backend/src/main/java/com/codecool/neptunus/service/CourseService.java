package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.model.dto.CourseDTO;
import com.codecool.neptunus.model.dto.NewCourseDTO;
import com.codecool.neptunus.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public List<Student> getStudentsForCourse(Long courseId){
//        return courseDAO.getStudentsOfCourse(courseId);
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public CourseDTO getCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return new CourseDTO(course.get().getId(), course.get().getName(), course.get().getTeacherName());
        }
//        TODO handle in controller advice
        throw new IllegalArgumentException("Invalid course ID");
    }

    public void addCourse(NewCourseDTO newCourseDTO) {
        Course course = new Course();
        course.setName(newCourseDTO.name());
        course.setTeacherName(newCourseDTO.teacherName());
        courseRepository.save(course);
    }

    public void addStudentToCourse(String studentId, Long courseId) {
        //        TODO courseRepository update method should be used
    }

    public void deleteStudentFromCourse(String studentId, Long courseId) {
        //        TODO courseRepository update method should be used
    }
}
