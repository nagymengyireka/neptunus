package com.codecool.neptunus.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String studentId;
    private String password;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Set<Role> roles;
    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    private List<Course> courses;
    private static final Set<String> OCCUPIED_IDS = new HashSet<>();
    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final Random RANDOM = new Random();
    private static final int CODE_LENGTH = 6;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId() {
        this.studentId = generateCode();
        OCCUPIED_IDS.add(studentId);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private static String createStudentId() {
        String generatedCode;
        do {
            generatedCode = generateCode();
        } while (OCCUPIED_IDS.contains(generatedCode));
        return generatedCode;
    }

    private static String generateCode() {
        StringBuilder studentCode = new StringBuilder();
        for (int i = 0; i < Student.CODE_LENGTH; i++) {
            if (RANDOM.nextBoolean()){
                studentCode.append(LETTERS[RANDOM.nextInt(LETTERS.length)]);
            } else {
                studentCode.append(RANDOM.nextInt(1, 10));
            }
        }
        return studentCode.toString();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
