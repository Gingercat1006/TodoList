package com.example.todo.common.exception;

public class TaskNotFoundException extends BusinessException {

    public TaskNotFoundException(Long id){
        super("そのタスクのidはみつかりませんでした。：" + id);
    }
    
}
