package com.codecool.neptunus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.*;

public class Student {
    private final String studentId;
    private String password;
    private String lastName;
    private String firstName;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    @JsonIgnore
    private final List<Course> courses;
    private static final Set<String> OCCUPIED_IDS = new HashSet<>();
    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final Random RANDOM = new Random();
    private static final int CODE_LENGTH = 6;

    public Student(String password, String lastName, LocalDate dateOfBirth, String firstName, Gender gender) {
        this.password = password;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.gender = gender;
        this.studentId = createStudentId();
        OCCUPIED_IDS.add(studentId);
        this.courses = new ArrayList<>();
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

    public String getPassword() {
        return password;
    }

    public String getStudentId() {
        return studentId;
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

    public List<Course> getCourses() {
        return courses;
    }

    public boolean checkStudentId(String id){
        return this.studentId.equals(id);
    }

    public void addCourse(Course course) {
        courses.add(course);
        return;
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        return;
    }

}
