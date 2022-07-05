package com.t02smith.gitto.repositories;

import com.t02smith.gitto.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("select u from AppUser u where u.username=?1")
    Optional<AppUser> findAppUserByUsername(String username);

    @Query("select u from AppUser u where u.email=?1")
    Optional<AppUser> findAppUserByEmail(String email);
}
