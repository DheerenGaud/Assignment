package com.aurionpro.exceptions;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super("Invalid Input Exception: " + message);
    }
}
