package com.darshana.userservice.controllers;

import com.darshana.userservice.dtos.UserDto;
import com.darshana.userservice.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserDto signUp(@RequestBody UserDto userDto){
        return userService.signup(userDto);
    }

    @PostMapping("/login/{email}")
    public String login(@PathVariable("email") String email){
        return userService.login(email);
    }
}
