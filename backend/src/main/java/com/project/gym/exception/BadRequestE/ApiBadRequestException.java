package com.project.gym.exception.BadRequestE;

/**
 * Az ApiBadRequestException osztálya.
 */
public class ApiBadRequestException extends RuntimeException{

    /**
     * ApiBadRequestException konstruktora örökölt adattal a RunTimeException-ből.
     *
     * @param message the message
     */
    public ApiBadRequestException(String message) {
        super(message);
    }

    /**
     * Apibad konstruktora.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ApiBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
