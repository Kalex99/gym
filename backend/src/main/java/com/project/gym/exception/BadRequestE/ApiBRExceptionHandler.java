package com.project.gym.exception.BadRequestE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * ApiBrExceptionHandler osztálya.
 */
@ControllerAdvice
public class ApiBRExceptionHandler {
    /**
     * Kezelje az API-kérelem-kivétel-válasz entitást.
     *
     * @param e the e
     * @return the response entity
     */
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
