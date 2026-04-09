package com.gicamube.taskmanager.service;

import com.gicamube.taskmanager.dto.TaskRequestDTO;
import com.gicamube.taskmanager.model.Task;
import com.gicamube.taskmanager.model.User;
import com.gicamube.taskmanager.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TaskService taskService;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateTaskSuccefully(){

        User user = new User();
        user.setId(1L);

        TaskRequestDTO dto = new TaskRequestDTO();
        dto.setTitle("Test Task");
        dto.setStatus("TODO");
        dto.setPriority("HIGH");
        dto.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(taskRepository.save(any(Task.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        var result = taskService.createTask(dto);

        // Assert
        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());

        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {

        TaskRequestDTO dto = new TaskRequestDTO();
        dto.setUserId(99L);

        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            taskService.createTask(dto);
        });

        assertEquals("User not found", ex.getMessage());
    }
}

