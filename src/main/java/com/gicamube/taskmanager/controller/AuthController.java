package com.gicamube.taskmanager.controller;

import com.gicamube.taskmanager.dto.AuthResponse;
import com.gicamube.taskmanager.dto.LoginRequest;
import com.gicamube.taskmanager.dto.RegisterRequest;
import com.gicamube.taskmanager.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Login", description = "Operaciones relacionadas con la gestión de usuarios")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation( summary = "Login", description = "Inicio de sesión")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar", description = "Registro de usuarios")
    public AuthResponse register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

}