package com.darshana.userservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
public class User extends BaseModel{
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
