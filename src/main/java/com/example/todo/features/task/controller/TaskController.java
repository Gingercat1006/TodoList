package com.example.todo.features.task.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping
    public String list(Model model) {
        List<TaskResponse> tasks = taskService.findAllTask();
        model.addAttribute("taskList", tasks);

        return "task/list";
    }

    // 編集画面表示
    @GetMapping("/update")
    public String select(Model model, @RequestParam("id") Long id) {
        UpdateTaskResponse task = taskService.findById(id);
        model.addAttribute("task", task);

        return "task/update";
    }

    //タスク削除
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        taskService.deleteTask(id);

        return "redirect:/taskLists";
    }

    // 編集画面の保存
    @PostMapping("/update")
    public String updateTask(@ModelAttribute UpdateTaskRequest request,
         @RequestParam("id") Long id) {
        taskService.updateTask(request, id);

        return "redirect:/taskLists";
    }
}
