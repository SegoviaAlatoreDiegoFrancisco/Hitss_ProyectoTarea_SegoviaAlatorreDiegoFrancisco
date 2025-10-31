package com.hitss.taskmanager.taskmanager.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hitss.taskmanager.taskmanager.models.Role;
import com.hitss.taskmanager.taskmanager.repositories.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!roleRepository.existsByName("ROLE_USER")) {
            roleRepository.save(new Role( "ROLE_USER"));
        }
        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            roleRepository.save(new Role( "ROLE_ADMIN"));
        }
    }
}
