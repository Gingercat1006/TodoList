package com.example.todo.features.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.common.exception.BusinessException;
import com.example.todo.common.exception.TaskNotFoundException;
import com.example.todo.features.task.dto.CreateTaskRequest;
import com.example.todo.features.task.dto.TaskResponse;
import com.example.todo.features.task.dto.UpdateTaskRequest;
import com.example.todo.features.task.dto.UpdateTaskResponse;
import com.example.todo.features.task.mapper.TaskMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskMapper taskMapper;

    // 全件取得
    public List<TaskResponse> findAllTask(){
        return taskMapper.findAllTask();
    }

    // 削除
    public int deleteTask(Long id) {
        int response = taskMapper.deleteTask(id);
        if(response == 0){
            throw new BusinessException("削除対象のタスクがありません");
        }
        return response;
    }

    // 編集（セット）
    public int updateTask(UpdateTaskRequest request) {
        int response = taskMapper.updateTask(request);
        if(response == 0){
            throw new BusinessException("編集対象のタスクがありません");
        }
        return response;
    }

    
    public UpdateTaskResponse findById(Long id) {
        UpdateTaskResponse responses = taskMapper.findById(id);
        if(responses == null){
            throw new TaskNotFoundException(id);
        }
        return responses;
    }

    public void insertTask(CreateTaskRequest request){
        if(request == null){
            throw new BusinessException("追加するタスクが不正です");
        }
        taskMapper.insertTask(request);
    }

}
