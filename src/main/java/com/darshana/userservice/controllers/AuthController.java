package com.darshana.userservice.controllers;

import com.darshana.userservice.dtos.*;
import com.darshana.userservice.models.SessionStatus;
import com.darshana.userservice.services.AuthService;
import com.darshana.userservice.services.EmailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;
    private EmailServiceImpl emailService;

    public AuthController(AuthService authService, EmailServiceImpl emailService) {
        this.authService = authService;
        this.emailService = emailService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignupRequestDto request){
        UserDto userDto = authService.signup(request.getEmail(), request.getPassword());
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(userDto.getEmail());
        emailDetails.setMsgBody("You have successfully created account");
        emailDetails.setSubject("Welcome to UserService");
        emailService.sendSimpleMail(emailDetails);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto request){
        return authService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request){
        return authService.logout(request.getToken(), request.getUserId());
    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validateToken(@RequestBody ValidateTokenRequestDto request){
        SessionStatus sessionStatus = authService.validate(request.getToken(), request.getUserId());
        return new ResponseEntity<>(sessionStatus, HttpStatus.OK);
    }
}
