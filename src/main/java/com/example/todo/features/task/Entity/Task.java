package com.example.todo.features.task.Entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class Task {
    private Long id;
    private String name;
    private String detail;
    private Long categoryId;
    private LocalDate dueDate;
    private boolean status;
}
