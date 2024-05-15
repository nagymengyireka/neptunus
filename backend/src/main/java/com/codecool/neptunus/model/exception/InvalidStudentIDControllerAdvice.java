package com.codecool.neptunus.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidStudentIDControllerAdvice extends RuntimeException{

    @ResponseBody
    @ExceptionHandler(InvalidStudentIDController.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidDateExceptionHandler(InvalidStudentIDController ex) {
        return ex.getMessage();
    }
}
