package com.project.gym.exception.BadRequestE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiBRExceptionHandler {
    @ExceptionHandler(value = {ApiBadRequestException.class})

    public ResponseEntity<Object> handleApiRequestException(ApiBadRequestException e) {
        HttpStatus notFound = HttpStatus.BAD_REQUEST;
        ApiBRException apiBRException = new ApiBRException(
                e.getMessage(),
                e,
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiBRException, notFound);
    }
}
