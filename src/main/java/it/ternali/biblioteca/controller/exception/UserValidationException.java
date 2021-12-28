package it.ternali.biblioteca.controller.exception;

public class UserValidationException extends RuntimeException{

    public UserValidationException(String message) {
        super(message);
    }

}
