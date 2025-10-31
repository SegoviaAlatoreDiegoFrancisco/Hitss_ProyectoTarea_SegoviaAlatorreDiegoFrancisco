package com.hitss.taskmanager.taskmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.taskmanager.taskmanager.models.User;
import com.hitss.taskmanager.taskmanager.services.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    //metodo para registrar un usuario (publico)
    @PostMapping("/register")    
    public ResponseEntity<User>registerUser(@Valid @RequestBody User user){
        if(userService.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().build();
        }
        User saved=userService.save(user);
        return ResponseEntity.ok(saved);
    }

    //metodo para listar usuarios
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    //metodo para obtener un usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);

        return user.map(ResponseEntity::ok)
                    .orElseGet(()-> ResponseEntity.notFound().build());
    }
    
    


}
