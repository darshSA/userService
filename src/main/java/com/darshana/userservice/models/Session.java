package com.darshana.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "sessions")
@Getter
@Setter
public class Session extends BaseModel{
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean active;
}
