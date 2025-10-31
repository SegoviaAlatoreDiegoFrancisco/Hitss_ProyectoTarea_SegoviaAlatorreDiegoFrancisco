package com.hitss.taskmanager.taskmanager.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hitss.taskmanager.taskmanager.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByOwnerUsername(String username);
}
