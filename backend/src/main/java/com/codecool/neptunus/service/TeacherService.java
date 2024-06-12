package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Role;
import com.codecool.neptunus.model.Teacher;
import com.codecool.neptunus.model.dto.TeacherDTO;
import com.codecool.neptunus.model.dto.newDTO.NewTeacherDTO;
import com.codecool.neptunus.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public TeacherDTO getTeacher(long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacherEntity = optionalTeacher.get();
            TeacherDTO teacher = new TeacherDTO(teacherEntity.getId(), teacherEntity.getPassword(), teacherEntity.getName(), teacherEntity.getDateOfBirth(), teacherEntity.getGender());

            return teacher;
        } else {
            throw new IllegalArgumentException("Invalid teacher ID.");
        }
    }

    public List<Course> getCourses(long id) {
        return teacherRepository.getCourses(id);
    }

    public String addTeacher(NewTeacherDTO newTeacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(newTeacherDTO.name());
        teacher.setPassword(passwordEncoder.encode(newTeacherDTO.password()));
        teacher.setGender(newTeacherDTO.gender());
        teacher.setDateOfBirth(newTeacherDTO.dateOfBirth());
        teacher.setUsername(newTeacherDTO.username());
        teacher.setRoles(Set.of(Role.ROLE_TEACHER));
        teacherRepository.save(teacher);
        return "Teacher created successfully";
    }

    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
