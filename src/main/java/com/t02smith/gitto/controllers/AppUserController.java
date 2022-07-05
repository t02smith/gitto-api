package com.t02smith.gitto.controllers;

import com.t02smith.gitto.dto.AppUserDTO;
import com.t02smith.gitto.errors.DuplicateUserDetailsException;
import com.t02smith.gitto.errors.UserNotFoundException;
import com.t02smith.gitto.requests.AppUserRequest;
import com.t02smith.gitto.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService userService;

    @PostMapping(path = "register")
    public ResponseEntity<String> register(@RequestBody AppUserRequest request) {
        try {
            userService.registerUser(request);
            return ResponseEntity.ok("User successfully created");
        } catch (DuplicateUserDetailsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "{username}")
    public ResponseEntity<AppUserDTO> getUser(@PathVariable("username") String username) {
        try {
            return ResponseEntity.ok(userService.getUserByUsername(username));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
