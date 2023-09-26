package org.example.exceptions;

public class InvalidAccessException extends RuntimeException {
    String message;

    public InvalidAccessException(String message) {
        super(message);
        this.message = message;
    }

}
