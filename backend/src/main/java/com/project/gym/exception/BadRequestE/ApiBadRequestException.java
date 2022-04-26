package com.project.gym.exception.BadRequestE;

public class ApiBadRequestException extends RuntimeException{

    public ApiBadRequestException(String message) {
        super(message);
    }

    public ApiBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
