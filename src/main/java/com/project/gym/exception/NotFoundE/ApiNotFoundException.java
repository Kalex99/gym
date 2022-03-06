package com.project.gym.exception.NotFoundE;

public class ApiNotFoundException extends RuntimeException{


    public ApiNotFoundException(String message) {
        super(message);
    }

    public ApiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
