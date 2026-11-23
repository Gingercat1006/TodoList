package com.example.todo.features.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(
                @NotBlank (message = "カテゴリ名は必須です")
                String name
        ) {
}