package com.codecool.neptunus.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GeneralControllerAdvice {

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String illegalArgumentHandler(IllegalArgumentException exception){
        return exception.getMessage();
    }
}
