package com.codecool.neptunus.controller.advice;

import com.codecool.neptunus.model.exception.InvalidStudentIDException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentControllerAdvice extends RuntimeException{

    @ResponseBody
    @ExceptionHandler(InvalidStudentIDException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidDateExceptionHandler(InvalidStudentIDException ex) {
        return ex.getMessage();
    }
}
