package com.api.rest.taskapp.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class TaskExceptions extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public TaskExceptions(String message, HttpStatus httpStatus) {

        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}