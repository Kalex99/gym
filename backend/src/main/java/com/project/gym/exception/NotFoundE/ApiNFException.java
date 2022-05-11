package com.project.gym.exception.NotFoundE;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * ApiNfException osztálya.
 */
public class ApiNFException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    /**
     * A ApiNfException konstruktora.
     *
     * @param message    the message
     * @param httpStatus the http status
     * @param timestamp  the timestamp
     */
    public ApiNFException(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
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
