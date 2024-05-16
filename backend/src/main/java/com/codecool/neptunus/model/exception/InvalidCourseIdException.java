package com.codecool.neptunus.model.exception;

public class InvalidCourseIdException extends RuntimeException {
    public InvalidCourseIdException() {
        super("Invalid course Id.");
    }
}
