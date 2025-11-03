package com.hitss.taskmanager.taskmanager.services;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AuthService {
    ResponseEntity<?> register(Map<String, String> request);
    ResponseEntity<?> login(Map<String, String> request);
}
