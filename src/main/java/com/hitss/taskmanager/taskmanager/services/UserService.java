package com.hitss.taskmanager.taskmanager.services;

import java.util.List;
import java.util.Optional;

import com.hitss.taskmanager.taskmanager.models.User;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);    
    User save(User user);
    boolean existsByUsername(String username);
}
