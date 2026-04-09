package com.gicamube.taskmanager.controller;

import com.gicamube.taskmanager.dto.UserRequestDTO;
import com.gicamube.taskmanager.dto.UserResponseDTO;
import com.gicamube.taskmanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDTO create(@Valid @RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
