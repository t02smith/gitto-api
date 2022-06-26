package com.t02smith.gitto.repositories;

import com.t02smith.gitto.entities.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoRepository extends JpaRepository<Repo, Long> {

    @Query("SELECT r FROM Repo r WHERE r.name = ?1")
    Optional<Repo> getRepoByName(String repoName);
}
