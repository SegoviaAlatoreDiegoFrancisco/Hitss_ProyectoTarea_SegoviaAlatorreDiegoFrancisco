package com.hitss.taskmanager.taskmanager.services;

import java.util.Optional;

import com.hitss.taskmanager.taskmanager.models.Role;

public interface RoleService {
    Optional<Role> findByName(String name);
}
