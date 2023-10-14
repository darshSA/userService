package com.darshana.userservice.services;

import com.darshana.userservice.dtos.SessionDto;
import com.darshana.userservice.dtos.UserDto;
import com.darshana.userservice.models.Session;
import com.darshana.userservice.models.User;
import com.darshana.userservice.repositories.SessionRepository;
import com.darshana.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    public UserService(UserRepository userRepository,
                       SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    private User convertDtoToUser(UserDto userDto){
        User user = new User();
        //if (userDto.getId() != "")
        //user.setUuid(UUID.fromString(userDto.getId()));
        user.setEmail(userDto.getEmail());
        user.setEncPass(userDto.getEncPass());

        return user;
    }

    private UserDto converToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getUuid().toString());
        userDto.setEmail(user.getEmail());
        userDto.setEncPass(user.getEncPass());

        return userDto;
    }
    public UserDto signup(UserDto userDto){
        return converToUserDto(userRepository.save(convertDtoToUser(userDto)));
    }

    public String login(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty())
            return "FAIL";
        else{
            Optional<Session> session = sessionRepository.findByUserAndActiveIsTrue(user.get());
            if(session.isEmpty()){
                Session session1 = new Session();
                session1.setUser(user.get());
                session1.setActive(true);
                session1.setToken("AAAA");
                Session session2 = sessionRepository.save(session1);
                return "OK";
            }
            else
                return "OK";
        }
    }
}
