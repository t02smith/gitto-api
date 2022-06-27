package com.t02smith.gitto.entities.blobs;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class TreeBlob  {

    @Id
    @Column(name = "hash", nullable = false, updatable = false, unique = true)
    private String hash;

    @Column(name="tree_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="parent_tree")
    private TreeBlob parent;

    @OneToMany(mappedBy = "tree")
    private Set<FileBlob> files = new HashSet<>();

    @OneToMany(mappedBy = "parent")
    private Set<TreeBlob> trees;


}
