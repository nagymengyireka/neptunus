package com.codecool.neptunus.controller;

import com.codecool.neptunus.model.dto.newDTO.NewStudentDTO;
import com.codecool.neptunus.model.dto.newDTO.NewTeacherDTO;
import com.codecool.neptunus.model.payload.JwtResponse;
import com.codecool.neptunus.model.payload.UserRequest;
import com.codecool.neptunus.security.jwt.JwtUtils;
import com.codecool.neptunus.service.StudentService;
import com.codecool.neptunus.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(TeacherService teacherService, StudentService studentService, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register/student")
    public String registerStudent(@RequestBody NewStudentDTO studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @PostMapping("/register/teacher")
    public String registerTeacher(@RequestBody NewTeacherDTO teacherRequest) {
        return teacherService.addTeacher(teacherRequest);
    }

    @PostMapping("/signin")
    public JwtResponse authenticateUser(@RequestBody UserRequest userRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.username(), userRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new JwtResponse(jwt, userDetails.getUsername(), roles);
    }
}
