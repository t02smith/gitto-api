package com.t02smith.gitto.requests;

public record AppUserRequest(
        String username,
        String email,
        String firstName,
        String surname,
        String password
) {
}
