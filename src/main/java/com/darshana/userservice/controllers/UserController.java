package com.darshana.userservice.controllers;

import com.darshana.userservice.dtos.SetUserRolesRequestDto;
import com.darshana.userservice.dtos.UserDto;
import com.darshana.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserDetails(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<UserDto> setUserRoles(@PathVariable("id") Long id,
                                                @RequestBody SetUserRolesRequestDto request){
        UserDto userDto = userService.setUserRoles(id, request.getRoleIds());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
