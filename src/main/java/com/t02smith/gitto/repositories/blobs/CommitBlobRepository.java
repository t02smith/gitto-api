package com.t02smith.gitto.repositories.blobs;

import com.t02smith.gitto.entities.blobs.CommitBlob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitBlobRepository extends JpaRepository<CommitBlob, String> {
}
