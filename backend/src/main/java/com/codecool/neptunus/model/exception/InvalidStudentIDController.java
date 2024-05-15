package com.codecool.neptunus.model.exception;

public class InvalidStudentIDController extends RuntimeException{

    public InvalidStudentIDController() {
        super("Invalid student id.");
    }
}
