package com.t02smith.gitto.dto;

import java.util.List;

public record AppUserDTO(
        String firstName,
        String surname,
        String username,
        String email,
        List<RepoDTO> repos
) {
}
