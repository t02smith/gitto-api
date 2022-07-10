package com.t02smith.gitto;

import com.t02smith.gitto.requests.AppUserRequest;
import com.t02smith.gitto.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GittoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GittoApplication.class, args);
	}

}
