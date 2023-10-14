package com.darshana.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionDto {
    private String id;
    private String userId;
    private String token;
    private boolean active;
}
