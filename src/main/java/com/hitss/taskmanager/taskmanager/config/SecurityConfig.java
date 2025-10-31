package com.hitss.taskmanager.taskmanager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
/*
 * Este calse es temporal hasta agregar la parte de seguridad JWT
 * Se cambiará hasta integrar la seguridad despues de testear los controladores
 *
 */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() 
            );

        return http.build();
    }
}