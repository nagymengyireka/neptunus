package com.codecool.neptunus.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void printExample(){
        Student student = new Student("ASD", "John", LocalDate.of(2001, 1, 1), "Doe", Gender.MALE);
        System.out.println(student.getStudentId());
    }
}