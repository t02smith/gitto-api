package com.t02smith.gitto.controllers;

import com.t02smith.gitto.dto.RepoDTO;
import com.t02smith.gitto.services.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/{userName}")
public class RepoController {

    private final RepoService service;

    @Autowired
    public RepoController(RepoService service) {
        this.service = service;
    }

//    @GetMapping(path = "{repoName}")
//    public ResponseEntity<RepoDTO> getRepositoryByName(@PathVariable(name="repoName") String repoName) {
//        return service.getRepoByName(repoName)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
}
