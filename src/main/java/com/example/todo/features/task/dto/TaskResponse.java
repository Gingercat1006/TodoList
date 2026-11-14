package com.example.todo.features.task.dto;

import java.time.LocalDate;

public record TaskResponse(
        Long id,
        String name,
        String detail,
        String categoryName,
        LocalDate dueDate,
        boolean status
){}
