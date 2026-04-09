package com.gicamube.taskmanager.service;

import com.gicamube.taskmanager.dto.UserRequestDTO;
import com.gicamube.taskmanager.dto.UserResponseDTO;
import com.gicamube.taskmanager.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static UserResponseDTO toDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
