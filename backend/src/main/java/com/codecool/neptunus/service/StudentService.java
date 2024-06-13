package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Role;
import com.codecool.neptunus.model.StudentIdGenerator;
import com.codecool.neptunus.model.dto.CourseDTO;
import com.codecool.neptunus.model.dto.newDTO.NewStudentDTO;
import com.codecool.neptunus.model.dto.StudentDTO;
import com.codecool.neptunus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.codecool.neptunus.model.Student;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final StudentIdGenerator studentIdGenerator;

    @Autowired
    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder, StudentIdGenerator studentIdGenerator) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.studentIdGenerator = studentIdGenerator;
    }


    public List<CourseDTO> getCoursesForStudent(Long studentId) {
        return studentRepository.getCourses(studentId).stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getTeacherName()))
                .toList();
    }

    public String addStudent(NewStudentDTO newStudent){
        Student student = new Student();
        student.setGender(newStudent.gender());
        student.setDateOfBirth(newStudent.dateOfBirth());
        student.setFirstName(newStudent.firstName());
        student.setLastName(newStudent.lastName());
        student.setPassword(passwordEncoder.encode(newStudent.password()));
        student.setStudentId(getUniqueId());
        student.setRoles(Set.of(Role.ROLE_STUDENT));
        studentRepository.save(student);
        return student.getStudentId();
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

    private String getUniqueId(){
        String generatedId;
        do {
            generatedId = studentIdGenerator.generateId();
        } while (doesIdExist(generatedId));
        return generatedId;
    }

    private boolean doesIdExist(String studentId){
        return studentRepository.existsByStudentId(studentId);
    }
}
