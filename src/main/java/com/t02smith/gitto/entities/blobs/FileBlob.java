package com.t02smith.gitto.entities.blobs;

import lombok.*;

import javax.persistence.*;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class FileBlob {

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

}
