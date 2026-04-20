package com.gicamube.taskmanager.controller;

import com.gicamube.taskmanager.dto.TaskRequestDTO;
import com.gicamube.taskmanager.dto.TaskResponseDTO;
import com.gicamube.taskmanager.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Tag(name = "Tareas", description = "Operaciones relacionadas con la gestión de tareas")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public TaskResponseDTO create(@Valid @RequestBody TaskRequestDTO task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<TaskResponseDTO> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO update(@PathVariable Long id, @RequestBody TaskRequestDTO task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}