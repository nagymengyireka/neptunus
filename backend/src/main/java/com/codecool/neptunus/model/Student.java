package com.codecool.neptunus.model;

import java.time.LocalDate;

public class Student {
    private final String studentId;
    private String password;
    private String lastName;
    private String firstName;
    private final LocalDate dateOfBirth;
    private final Gender gender;

    public Student(String password, String lastName, LocalDate dateOfBirth, String firstName, Gender gender) {
        this.password = password;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.gender = gender;
        this.studentId = createStudentId();
    }

//    TODO Gergo
    private static String createStudentId(){
        return null;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }
}
