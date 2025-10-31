package com.hitss.taskmanager.taskmanager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitss.taskmanager.taskmanager.models.Task;
import com.hitss.taskmanager.taskmanager.models.repositories.TaskRepository;
import com.hitss.taskmanager.taskmanager.services.TaskService;


@Service
public abstract class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Task>findAll(){
        return taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public boolean deleteById(Long id) {
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        return taskRepository.findById(id).map(existing ->{
            existing.setTitle(task.getTitle());
            existing.setDescription(task.getDescription());
            existing.setDone(task.getDone());
            return taskRepository.save(existing);
        });
    }

  
}
