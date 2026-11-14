package com.example.todo.features.task.dto;

import java.time.LocalDate;

public record CreateTaskRequest(
    String name,
    String detail,
    Long categoryId,
    LocalDate dueDate
) {}
