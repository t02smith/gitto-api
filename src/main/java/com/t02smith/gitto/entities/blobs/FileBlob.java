package com.t02smith.gitto.entities.blobs;

import com.t02smith.gitto.dto.DTO;
import com.t02smith.gitto.dto.blobs.FileBlobDTO;
import lombok.*;

import javax.persistence.*;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class FileBlob implements DTO<FileBlobDTO> {

    @Id
    @Column(name = "hash", nullable = false, updatable = false, unique = true)
    private String hash;

    @Column(name = "filename", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "tree", nullable = false)
    private TreeBlob tree;

    @Transient
    private String data;

    @Override
    public FileBlobDTO toDTO() {
        return new FileBlobDTO(hash, name, tree.getHash());
    }
}
