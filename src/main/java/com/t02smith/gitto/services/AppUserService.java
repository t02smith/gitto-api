package com.t02smith.gitto.services;

import com.t02smith.gitto.dto.AppUserDTO;
import com.t02smith.gitto.entities.AppUser;
import com.t02smith.gitto.errors.DuplicateUserDetailsException;
import com.t02smith.gitto.errors.UserNotFoundException;
import com.t02smith.gitto.repositories.AppUserRepository;
import com.t02smith.gitto.requests.AppUserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService implements UserDetailsService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findAppUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    @Transactional
    public void registerUser(AppUserRequest user) throws DuplicateUserDetailsException {
        // check email + username aren't taken
        if (userRepository.findAppUserByUsername(user.username()).isPresent())
            throw new DuplicateUserDetailsException(String.format("Username '%s' already taken", user.username()));

        if (userRepository.findAppUserByEmail(user.email()).isPresent())
            throw new DuplicateUserDetailsException(String.format("Email '%s' already taken", user.email()));

        userRepository.save(
                new AppUser(user.firstName(), user.surname(), user.username(), user.email(), passwordEncoder.encode(user.password()))
        );
    }

    public AppUserDTO getUserByUsername(String username) {
        return userRepository.findAppUserByUsername(username)
                .map(AppUser::toDTO)
                .orElseThrow(() -> new UserNotFoundException(String.format("Username '%s' not found", username)));
    }
}
