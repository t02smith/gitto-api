package com.t02smith.gitto.errors;

public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
