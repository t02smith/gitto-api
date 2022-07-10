package com.t02smith.gitto.configuration;

import com.t02smith.gitto.requests.AppUserRequest;
import com.t02smith.gitto.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    CommandLineRunner run(AppUserService service) {
        return args -> {
            service.registerUser(new AppUserRequest("t02smith", "tom@t02smith.com", "tom", "smith", "password"));
        };
    }
}
