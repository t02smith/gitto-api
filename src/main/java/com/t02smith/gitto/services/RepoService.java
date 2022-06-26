package com.t02smith.gitto.services;

import com.t02smith.gitto.dto.RepoDTO;
import com.t02smith.gitto.entities.Repo;
import com.t02smith.gitto.repositories.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepoService {

    private final RepoRepository repository;

    @Autowired
    public RepoService(RepoRepository repository) {
        this.repository = repository;
    }

    public Optional<RepoDTO> getRepoByName(String repoName) {
        return repository.getRepoByName(repoName)
                .map(Repo::toDTO);
    }
}
