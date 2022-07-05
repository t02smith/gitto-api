package com.t02smith.gitto.services;

import com.t02smith.gitto.dto.AppUserDTO;
import com.t02smith.gitto.entities.AppUser;
import com.t02smith.gitto.errors.DuplicateUserDetailsException;
import com.t02smith.gitto.errors.UserNotFoundException;
import com.t02smith.gitto.repositories.AppUserRepository;
import com.t02smith.gitto.requests.AppUserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService {

    private final AppUserRepository userRepository;

    @Transactional
    public void registerUser(AppUserRequest user) throws DuplicateUserDetailsException {
        // check email + username aren't taken
        if (userRepository.findAppUserByUsername(user.username()).isPresent())
            throw new DuplicateUserDetailsException(String.format("Username '%s' already taken", user.username()));

        if (userRepository.findAppUserByEmail(user.email()).isPresent())
            throw new DuplicateUserDetailsException(String.format("Email '%s' already taken", user.email()));

        userRepository.save(
                new AppUser(user.firstName(), user.surname(), user.username(), user.email(), user.password())
        );
    }

    public AppUserDTO getUserByUsername(String username) {
        return userRepository.findAppUserByUsername(username)
                .map(AppUser::toDTO)
                .orElseThrow(() -> new UserNotFoundException(String.format("Username '%s' not found", username)));
    }
}
