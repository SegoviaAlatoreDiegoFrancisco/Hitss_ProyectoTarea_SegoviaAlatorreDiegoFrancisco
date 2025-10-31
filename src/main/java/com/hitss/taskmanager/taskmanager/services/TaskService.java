package com.hitss.taskmanager.taskmanager.services;

import java.util.List;
import java.util.Optional;

import com.hitss.taskmanager.taskmanager.models.Task;

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task);
    Optional<Task> update(Long id, Task task);
    boolean deleteById(Long id);
}
