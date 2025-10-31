package com.hitss.taskmanager.taskmanager.services.impl;

import java.util.Optional;

import com.hitss.taskmanager.taskmanager.models.Role;
import com.hitss.taskmanager.taskmanager.repositories.RoleRepository;
import com.hitss.taskmanager.taskmanager.services.RoleService;

public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
    
    
    
}
