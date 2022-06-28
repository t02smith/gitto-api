package com.t02smith.gitto.controllers;

import com.sun.istack.NotNull;
import com.t02smith.gitto.services.BlobService;
import com.t02smith.gitto.configuration.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = Constants.API_PREFIX + "{repoName}")
public class BlobController {

    private final BlobService blobService;

    @Autowired
    public BlobController(BlobService blobService) {
        this.blobService = blobService;
    }


    /**
     * Upload a new file to a repository
     * @param repoName the name of the repository
     * @param file the file content to upload
     * @param filepath the location of the file within the repository tree
     * @return A response stating whether the upload was successful`
     */
    @PostMapping(path = "upload")
    public ResponseEntity<String> upload(@NotNull @PathVariable("repoName") String repoName,
                                         @NotNull @RequestParam MultipartFile file,
                                         @NotNull @RequestParam String filepath) {
        return ResponseEntity.ok("ok");
    }

}
