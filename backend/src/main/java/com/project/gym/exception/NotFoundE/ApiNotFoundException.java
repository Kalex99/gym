package com.project.gym.exception.NotFoundE;

/**
 * Az ApitNotFound exception osztálya.
 */
public class ApiNotFoundException extends RuntimeException{


    /**
     * Az ApitNotFound konstruktora örökölt adattal.
     *
     * @param message the message
     */
    public ApiNotFoundException(String message) {
        super(message);
    }

    /**
     * Az ApitNotFound konstruktora.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ApiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
