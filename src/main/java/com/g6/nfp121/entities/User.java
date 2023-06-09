package com.g6.nfp121.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String firstName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

    @NotBlank
    private String password;

    public User() {}

    public User(String name, String firstName, String email) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    public User(String name, String firstName, String email, String password) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public Boolean isAdmin() {
        return this.roles.contains(Role.ROLE_ADMIN);
    }

    @Override
    public String toString() {
        return "User(id: " + id + ", name: " + name + ", firstname: " + firstName + ",  email: " + email;
    }
}
