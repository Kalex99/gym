package com.project.gym.exception.NotFoundE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * ApiNfExceptionHandler osztálya.
 */
@ControllerAdvice
public class ApiNFExceptionHandler {

    /**
     * Kezelje az API kérelem kivétel válasz entitást.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(value = {ApiNotFoundException.class})

    public ResponseEntity<Object> handleApiRequestException(ApiNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiNFException apiNFException = new ApiNFException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiNFException, notFound);
    }
}
