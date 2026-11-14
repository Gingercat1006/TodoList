package com.example.todo.features.task.dto;

import java.time.LocalDate;

public record UpdateTaskResponse(
    Long id,
    String name,
    String detail,
    Long categoryId,
    LocalDate dueDate,
    boolean status
){}