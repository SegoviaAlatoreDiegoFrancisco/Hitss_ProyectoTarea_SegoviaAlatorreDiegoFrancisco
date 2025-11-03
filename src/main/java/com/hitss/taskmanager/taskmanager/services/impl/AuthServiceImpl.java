package com.hitss.taskmanager.taskmanager.services.impl;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hitss.taskmanager.taskmanager.config.JwtService;
import com.hitss.taskmanager.taskmanager.models.Role;
import com.hitss.taskmanager.taskmanager.models.User;
import com.hitss.taskmanager.taskmanager.repositories.RoleRepository;
import com.hitss.taskmanager.taskmanager.repositories.UserRepository;
import com.hitss.taskmanager.taskmanager.services.AuthService;
@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public ResponseEntity<?> login(Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        
        User user = userRepository.findByUsername(username).orElseThrow();
        String token= jwtService.generateToken(
            new org.springframework.security.core.userdetails.User(
                user.getUsername()
                ,user.getPassword()
                ,Collections.emptyList())
        );
        return ResponseEntity.ok(Map.of("token", token));
    }
    @Override
    public ResponseEntity<?> register(Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        Role userRole= roleRepository.findByName(username).orElseGet(() -> roleRepository.save(new Role("USER"))); 
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Collections.singletonList(userRole));
        userRepository.save(user);
        return ResponseEntity.ok(Map.of("message", "Usuario registrado con éxito"));

    }

    
}
