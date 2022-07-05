package com.t02smith.gitto.entities;

import com.t02smith.gitto.dto.AppUserDTO;
import com.t02smith.gitto.dto.DTO;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Table
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class AppUser implements DTO<AppUserDTO> {

    @Id
    @SequenceGenerator(name="user_seq",sequenceName="user_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "username", nullable = false, updatable = false, unique = true)
    private String username;

    @Column(name = "email", updatable = false, nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Repo> repos = new HashSet<>();

    public AppUser(String firstName, String surname, String username, String email, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public AppUserDTO toDTO() {
        return new AppUserDTO(
                firstName,
                surname,
                username,
                email,
                repos.stream().map(Repo::toDTO).toList()
        );
    }
}
