package com.example.springapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serilVersion = 1;

    public UserNotFoundException(String message){
        super(message);
    }

}
