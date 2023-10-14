package com.darshana.userservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class User extends BaseModel{
    private String email;
    private String encPass;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Session> sessions;
}
