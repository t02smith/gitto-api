package com.t02smith.gitto.services;

import com.t02smith.gitto.repositories.blobs.CommitBlobRepository;
import com.t02smith.gitto.repositories.blobs.FileBlobRepository;
import com.t02smith.gitto.repositories.blobs.TreeBlobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

/**
 * Facilitates the transfer of blobs
 */
@Service
public class BlobService {

    // file data FileBlob
    private final FileBlobRepository fileBlobRepository;

    // tree data TreeBlob
    private final TreeBlobRepository treeBlobRepository;

    // commit data CommitBlob
    private final CommitBlobRepository commitBlobRepository;

    @Autowired
    public BlobService(FileBlobRepository fileBlobRepository, TreeBlobRepository treeBlobRepository, CommitBlobRepository commitBlobRepository) {
        this.fileBlobRepository = fileBlobRepository;
        this.treeBlobRepository = treeBlobRepository;
        this.commitBlobRepository = commitBlobRepository;
    }

    @Transactional
    public void upload(String repoName, MultipartFile file, String filepath) throws IOException {

    }
}
