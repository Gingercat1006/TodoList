package com.example.todo.features.category.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.features.category.dto.CategoryResponse;
import com.example.todo.features.category.dto.CreateCategoryRequest;
import com.example.todo.features.category.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        List<CategoryResponse> categories = categoryService.findAllCategory();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/insert")
    public String insertForm(Model model) {
        model.addAttribute("category", new CreateCategoryRequest(""));
        return "category/form";
    }

    @PostMapping("/insert")
    public String insert(
            @Valid @ModelAttribute("category") CreateCategoryRequest request,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/form";
        }
        categoryService.insertCategory(request);
        return "redirect:/categories";
    }
}
