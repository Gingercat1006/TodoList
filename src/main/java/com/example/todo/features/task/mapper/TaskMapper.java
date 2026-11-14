package com.example.todo.features.task.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.features.task.Entity.Task;
import com.example.todo.features.task.dto.TaskResponse;
import com.example.todo.features.task.dto.UpdateTaskResponse;

@Mapper 
public interface TaskMapper {
    //新規タスク追加
    int insertTask(Task task);

    //タスク削除
    int deleteTask(Long id);

    //タスク更新
    int updateTask(Long id);

    //タスク全件取得
    List<TaskResponse> findAllTask();

    //タスク検索
    UpdateTaskResponse findById(Long id);
}
