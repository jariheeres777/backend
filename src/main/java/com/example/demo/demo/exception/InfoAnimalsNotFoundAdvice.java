package com.example.demo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InfoAnimalsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(InfoAnimalsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String InfoAnimalsNotFoundHandler(InfoAnimalsNotFoundException ex) {
        return ex.getMessage();
    }
}
