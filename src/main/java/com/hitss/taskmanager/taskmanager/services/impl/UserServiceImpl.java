package com.hitss.taskmanager.taskmanager.services.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitss.taskmanager.taskmanager.models.Role;
import com.hitss.taskmanager.taskmanager.models.User;
import com.hitss.taskmanager.taskmanager.repositories.RoleRepository;
import com.hitss.taskmanager.taskmanager.repositories.UserRepository;
import com.hitss.taskmanager.taskmanager.services.UserService;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Role roleUser = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("Rol ROLE_USER no encontrado"));
            user.getRoles().add(roleUser);
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    
    
}
    