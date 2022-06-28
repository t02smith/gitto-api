package com.t02smith.gitto.entities.blobs;

import com.t02smith.gitto.dto.DTO;
import com.t02smith.gitto.dto.blobs.TreeBlobDTO;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class TreeBlob implements DTO<TreeBlobDTO> {

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
    private Set<TreeBlob> trees = new HashSet<>();

    @Override
    public TreeBlobDTO toDTO() {
        return new TreeBlobDTO(
                hash,
                name,
                files.stream().map(FileBlob::getHash).toList(),
                trees.stream().map(TreeBlob::toDTO).toList()
        );
    }
}
