package com.example.todo.features.task.dto;

import java.time.LocalDate;

public record UpdateTaskRequest(
    Long id,
    String name,
    Long category,
    LocalDate dueDate,
    boolean status
) {
    
}
