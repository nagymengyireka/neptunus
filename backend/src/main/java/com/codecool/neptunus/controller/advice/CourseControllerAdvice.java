package com.codecool.neptunus.controller.advice;

import com.codecool.neptunus.model.exception.InvalidCourseIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CourseControllerAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidCourseIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidCourseIdException(InvalidCourseIdException e){
        return e.getMessage();
    }
}
