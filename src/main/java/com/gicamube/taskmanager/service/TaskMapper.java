package com.gicamube.taskmanager.service;

import com.gicamube.taskmanager.dto.TaskRequestDTO;
import com.gicamube.taskmanager.dto.TaskResponseDTO;
import com.gicamube.taskmanager.model.Task;
import com.gicamube.taskmanager.model.User;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto, User user) {
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(Enum.valueOf(com.gicamube.taskmanager.model.Status.class, dto.getStatus()))
                .priority(Enum.valueOf(com.gicamube.taskmanager.model.Priority.class, dto.getPriority()))
                .user(user)
                .build();
    }

    public static TaskResponseDTO toDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus().name())
                .priority(task.getPriority().name())
                .createdAt(task.getCreatedAt())
                .userId(task.getUser().getId())
                .build();
    }
}
