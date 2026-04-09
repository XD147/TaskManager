package com.gicamube.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDTO {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private String status;

    @NotNull
    private String priority;

    @NotNull
    private Long userId;
}
