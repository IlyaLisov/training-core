package com.example.trainingcore.web.controller;

import com.example.trainingcore.model.exception.ResourceAlreadyExistsException;
import com.example.trainingcore.model.exception.ResourceNotFoundException;
import com.example.trainingcore.model.exception.UserNotActiveException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String resourceNotFound() {
        return "Not found.";
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public String resourceAlreadyExists() {
        return "Already exists.";
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public String internalAuthentication() {
        return "Authentication failed.";
    }

    @ExceptionHandler({LockedException.class, UserNotActiveException.class})
    public String locked() {
        return "Account is not activated.";
    }

    @ExceptionHandler
    public String exception(
            final Exception e
    ) {
        e.printStackTrace();
        return e.getMessage();
    }

}
