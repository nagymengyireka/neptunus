package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.dto.CourseDTO;
import com.codecool.neptunus.model.dto.NewStudentDTO;
import com.codecool.neptunus.model.dto.StudentDTO;
import com.codecool.neptunus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.codecool.neptunus.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<CourseDTO> getCoursesForStudent(Long studentId) {
        return studentRepository.getCourses(studentId).stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getTeacherName()))
                .toList();
    }

    public void addStudent(NewStudentDTO newStudent){
        Student student = new Student();
        student.setGender(newStudent.gender());
        student.setDateOfBirth(newStudent.dateOfBirth());
        student.setFirstName(newStudent.firstName());
        student.setLastName(newStudent.lastName());
        student.setPassword(newStudent.password());
        student.setStudentId();
        studentRepository.save(student);
    }

    public void removeStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
    public StudentDTO getStudent(Long studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()){
            return new StudentDTO(
                    student.get().getId(),
                    student.get().getStudentId(),
                    student.get().getPassword(),
                    student.get().getLastName(),
                    student.get().getFirstName(),
                    student.get().getDateOfBirth(),
                    student.get().getGender()
            );
        }
        throw new IllegalArgumentException("Invalid student ID!");
    }
}
