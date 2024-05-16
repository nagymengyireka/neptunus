package com.codecool.neptunus.model;

import java.time.LocalDate;
import java.util.*;

public class Student {
    private final String studentId;
    private String password;
    private String lastName;
    private String firstName;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private final List<Course> courses;
    private static final Set<String> occupiedIds = new HashSet<>();
    private static final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final Random random = new Random();
    private static final int CODE_LENGTH = 6;

    public Student(String password, String lastName, LocalDate dateOfBirth, String firstName, Gender gender) {
        this.password = password;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.gender = gender;
        this.studentId = createStudentId();
        occupiedIds.add(studentId);
        this.courses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    private static String createStudentId() {
        String generatedCode;
        do {
            generatedCode = generateCode();
        } while (occupiedIds.contains(generatedCode));
        return generatedCode;
    }

    private static String generateCode() {
        StringBuilder studentCode = new StringBuilder();
        for (int i = 0; i < Student.CODE_LENGTH; i++) {
            if (random.nextBoolean()){
                studentCode.append(letters[random.nextInt(letters.length)]);
            } else {
                studentCode.append(random.nextInt(1, 10));
            }
        }
        return studentCode.toString();
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

    public List<Course> getCourses() {
        return courses;
    }

    public boolean checkStudentId(String id){
        return this.studentId.equals(id);
    }
}
