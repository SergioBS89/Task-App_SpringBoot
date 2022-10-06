package com.api.rest.taskapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* ------------------- CLASS TO MANAGE EXCEPTIONS IN APP ------------------- */
// To show the correct status when an exception is launched (500, 400...)
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { TaskExceptions.class })
    protected ResponseEntity<Object> handleConflict(TaskExceptions tex, WebRequest request) {
        String bodyOfresponse = tex.getMessage();
        return handleExceptionInternal(tex, bodyOfresponse, new HttpHeaders(),
                tex.getHttpStatus(), request);
    }

}