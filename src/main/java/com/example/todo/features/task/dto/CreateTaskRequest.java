package com.example.todo.features.task.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(
    @NotNull(message = "タスク名は必須です") 
    @Size(max = 50, message= "50文字以内でお願いします")
    String name,

    @Size(max = 250, message="250文字以内でお願いします")
    String detail,
    Long categoryId,
    @NotNull (message="期限日は必須です")
    LocalDate dueDate
) {}
