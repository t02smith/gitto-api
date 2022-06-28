package com.t02smith.gitto.entities.blobs;

import com.t02smith.gitto.dto.DTO;
import com.t02smith.gitto.dto.blobs.CommitBlobDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class CommitBlob implements DTO<CommitBlobDTO> {

    @Id
    @Column(name = "hash", nullable = false, updatable = false, unique = true)
    private String hash;

    // TODO user datatype
    @Column(name = "author", nullable = false, updatable = false)
    private String author;

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "parent_hash", updatable = false)
    private CommitBlob parent;

    @Column(name = "timestamp", updatable = false, nullable = false)
    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "tree", updatable = false, nullable = false)
    private TreeBlob tree;

    @Override
    public CommitBlobDTO toDTO() {
        return new CommitBlobDTO(hash, author, message, parent.getHash(), timestamp, tree.getHash());
    }
}
