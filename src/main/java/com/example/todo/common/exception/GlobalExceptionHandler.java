package com.example.todo.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFound(TaskNotFoundException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "task/error/404";
    }

    @ExceptionHandler(BusinessException.class)
    public String handleBusinessException(
            BusinessException e,
            Model model) {
        model.addAttribute("message", e.getMessage());
        return "task/error/business";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(
            Exception e,
            Model model) {
        model.addAttribute("message", "予期しないエラーが発生しました");
        return "task/error/500";
    }
}
