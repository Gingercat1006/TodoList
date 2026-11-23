package com.example.todo.features.task.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public record UpdateTaskResponse(
    Long id,
    String name,
    String detail,
    Long categoryId,
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    LocalDate dueDate,
    boolean status
){}