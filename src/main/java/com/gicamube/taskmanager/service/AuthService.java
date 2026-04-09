package com.gicamube.taskmanager.service;

import com.gicamube.taskmanager.dto.AuthResponse;
import com.gicamube.taskmanager.dto.LoginRequest;
import com.gicamube.taskmanager.dto.RegisterRequest;
import com.gicamube.taskmanager.model.User;
import com.gicamube.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest register){

        User user = User.builder()
                .name(register.getName())
                .email(register.getEmail())
                .password(register.getPassword())
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
