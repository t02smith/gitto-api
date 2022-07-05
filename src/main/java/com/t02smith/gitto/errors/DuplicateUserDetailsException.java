package com.t02smith.gitto.errors;

public class DuplicateUserDetailsException extends IllegalStateException {

    public DuplicateUserDetailsException(String msg) {
        super(msg);
    }
}
