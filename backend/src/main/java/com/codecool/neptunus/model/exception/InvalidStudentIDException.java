package com.codecool.neptunus.model.exception;

public class InvalidStudentIDException extends RuntimeException{

    public InvalidStudentIDException() {
        super("Invalid student id.");
    }
}
