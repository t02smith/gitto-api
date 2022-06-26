package com.t02smith.gitto.entities;

import com.t02smith.gitto.dto.DTO;
import com.t02smith.gitto.dto.RepoDTO;
import lombok.*;

import javax.persistence.*;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class Repo implements DTO<RepoDTO> {

    @Id
    @SequenceGenerator(name="repo_seq",sequenceName="repo_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repo_seq")
    @Column(name = "repo_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Repo(String name) {
        this.name = name;
    }

    @Override
    public RepoDTO toDTO() {
        return new RepoDTO(id, name);
    }
}
