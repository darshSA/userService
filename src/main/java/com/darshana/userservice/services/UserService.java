package com.darshana.userservice.services;

import com.darshana.userservice.dtos.SessionDto;
import com.darshana.userservice.dtos.UserDto;
import com.darshana.userservice.models.Role;
import com.darshana.userservice.models.Session;
import com.darshana.userservice.models.User;
import com.darshana.userservice.repositories.RoleRepository;
import com.darshana.userservice.repositories.SessionRepository;
import com.darshana.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserDto getUserDetails(Long id){
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty())
            return null;

        return UserDto.from(userOptional.get());
    }

    public UserDto setUserRoles(Long id, List<Long> roleIds){
        Optional<User> userOptional = userRepository.findById(id);
        List<Role> roles = roleRepository.findAllByIdIn(roleIds);

        if(userOptional.isEmpty())
            return null;

        User user = userOptional.get();
        user.setRoles(Set.copyOf(roles));

        User savedUser = userRepository.save(user);
        return UserDto.from(savedUser);
    }


}
