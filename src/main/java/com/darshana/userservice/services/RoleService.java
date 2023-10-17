package com.darshana.userservice.services;

import com.darshana.userservice.models.Role;
import com.darshana.userservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name){
        Role role = new Role();
        role.setRole(name);

        Role savedRole = roleRepository.save(role);
        return savedRole;

    }
}
