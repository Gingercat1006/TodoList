package com.example.todo.features.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(
                @NotBlank (message = "カテゴリ名は必須です")
                @Size(max = 50, message = "50文字以内でお願いします")
                String name
        ) {
}