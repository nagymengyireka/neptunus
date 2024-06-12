package com.codecool.neptunus.security.service;

import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.model.Teacher;
import com.codecool.neptunus.repository.StudentRepository;
import com.codecool.neptunus.model.Role;
import com.codecool.neptunus.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public UserDetailsServiceImpl(StudentRepository repository, TeacherRepository teacherRepository) {
        this.studentRepository = repository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findByStudentId(username);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<SimpleGrantedAuthority> roles = new ArrayList<>();
            for (Role role : student.getRoles()) {
                roles.add(new SimpleGrantedAuthority(role.name()));
            }

            return new User(student.getStudentId(), student.getPassword(), roles);
        } else {
            Teacher teacher = teacherRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

            List<SimpleGrantedAuthority> roles = new ArrayList<>();
            for (Role role : teacher.getRoles()) {
                roles.add(new SimpleGrantedAuthority(role.name()));
            }

            return new User(teacher.getUsername(), teacher.getPassword(), roles);
        }
    }
}
