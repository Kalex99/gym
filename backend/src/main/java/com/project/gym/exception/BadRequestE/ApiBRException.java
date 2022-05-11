package com.project.gym.exception.BadRequestE;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * APIBR exception osztálya.
 */
public class ApiBRException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    /**
     * APIBR konstuktora adatokkal.
     *
     * @param message    the message
     * @param throwable  the throwable
     * @param httpStatus the http status
     * @param timestamp  the timestamp
     */
    public ApiBRException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get throwable throwable.
     *
     * @return the throwable
     */
    public Throwable getThrowable(){
        return throwable;
    }

    /**
     * Gets http status.
     *
     * @return the http status
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
