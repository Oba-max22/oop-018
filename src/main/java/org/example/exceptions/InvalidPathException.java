package org.example.exceptions;

public class InvalidPathException extends RuntimeException {

    String message;

    public InvalidPathException(String message) {
        super(message);
        this.message = message;
    }

}
