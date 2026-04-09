package com.gicamube.taskmanager.service;

import com.gicamube.taskmanager.dto.*;
import com.gicamube.taskmanager.model.*;
import com.gicamube.taskmanager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskResponseDTO createTask(TaskRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = TaskMapper.toEntity(dto, user);
        task.setCreatedAt(LocalDateTime.now());

        Task saved = taskRepository.save(task);

        return TaskMapper.toDTO(saved);
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toDTO)
                .toList();
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task response = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return TaskMapper.toDTO(response);
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO updatedTask) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(Enum.valueOf(com.gicamube.taskmanager.model.Status.class, updatedTask.getStatus()));
        task.setPriority(Enum.valueOf(com.gicamube.taskmanager.model.Priority.class, updatedTask.getPriority()));
        Task saved = taskRepository.save(task);

        return TaskMapper.toDTO(saved);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
