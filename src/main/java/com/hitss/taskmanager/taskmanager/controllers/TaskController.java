package com.hitss.taskmanager.taskmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitss.taskmanager.taskmanager.models.Task;
import com.hitss.taskmanager.taskmanager.services.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Tasks", description = "Operaciones relacionadas con tareas")
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="*")
public class TaskController {
    
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // metodo para btener todas las tareas
    @Operation(summary = "Obtener todas las tareas", description = "Devuelve la lista completa de tareas registradas.")
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    //metodo para obtener una tarea por ID
    @Operation(summary = "Busca por Id", description = "Devuelve la tarea a partir de un Id si hay coincidencia.")
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).
                    orElseGet(() -> ResponseEntity.notFound().build());
    }

    //metodo para crear una nueva tarea
    @Operation(summary = "Crea tarea", description = "Da de alta una tarea y te devuelve la estructura.")
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        Task created = taskService.save(task);
        return ResponseEntity.ok(created);
    }
    //metodo para actualizar una tarea
    @Operation(summary = "Modificar", description = "Modifica tareas a partir de un Id.")

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> updated = taskService.update(id, task);
        return updated.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // metodo para liminar una tarea
    @Operation(summary = "Eliminar", description = "Elimina de la base de datos (no es baja Lógica).")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean deleted = taskService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }

}
