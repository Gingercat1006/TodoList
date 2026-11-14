package com.example.todo.features.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.features.task.dto.TaskResponse;
import com.example.todo.features.task.dto.UpdateTaskRequest;
import com.example.todo.features.task.dto.UpdateTaskResponse;
import com.example.todo.features.task.mapper.TaskMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class TaskService {
    private final TaskMapper taskMapper;


    //全件取得
    public List<TaskResponse> findAllTask(){
        return taskMapper.findAllTask();
    }

    //削除
    public int deleteTask(Long id){
        return taskMapper.deleteTask(id);
    }

    //編集
    public int updateTask(UpdateTaskRequest request,Long id){
        return taskMapper.updateTask(id);
    }

    public UpdateTaskResponse findById(Long id){
        return taskMapper.findById(id);
    }

    
}
