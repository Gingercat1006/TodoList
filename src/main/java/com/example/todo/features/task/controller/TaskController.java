package com.example.todo.features.task.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.features.category.dto.CategoryResponse;
import com.example.todo.features.category.service.CategoryService;
import com.example.todo.features.task.dto.CreateTaskRequest;
import com.example.todo.features.task.dto.TaskResponse;
import com.example.todo.features.task.dto.UpdateTaskRequest;
import com.example.todo.features.task.dto.UpdateTaskResponse;
import com.example.todo.features.task.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/taskLists")
public class TaskController {
    private final TaskService taskService;
    private final CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        List<TaskResponse> tasks = taskService.findAllTask();
        model.addAttribute("taskList", tasks);
        System.out.println(tasks);
        return "task/list";
    }

    // 編集画面表示
    @GetMapping("/update")
    public String select(Model model, @RequestParam(required = false, value = "id") Long id) {
        UpdateTaskResponse task = taskService.findById(id);
        List<CategoryResponse> categories = categoryService.findAllCategory();
        model.addAttribute("task", task);
        model.addAttribute("categories", categories);
        System.out.println(task);
        return "task/form";
    }

    // タスク削除
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        taskService.deleteTask(id);

        return "redirect:/taskLists";
    }

    // 編集画面の保存
    @PostMapping("/update")
    public String updateTask(@ModelAttribute UpdateTaskRequest request) {
        taskService.updateTask(request);

        return "redirect:/taskLists";
    }

    //追加画面表示
    @GetMapping("/insert")
    public String insertForm(Model model) {
        model.addAttribute("task", new CreateTaskRequest("", "", null, null));

        model.addAttribute(
                "categories",
                categoryService.findAllCategory());

        return "task/form";
    }

    //新規タスク保存
    @PostMapping("/insert")
    public String insertTask(@ModelAttribute CreateTaskRequest request) {
        taskService.insertTask(request);
        return "redirect:/taskLists";
    }
}
