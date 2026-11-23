package com.example.todo.features.category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.common.exception.BusinessException;
import com.example.todo.features.category.dto.CategoryResponse;
import com.example.todo.features.category.dto.CreateCategoryRequest;
import com.example.todo.features.category.mapper.CategoryMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;

    //カテゴリ全件取得
    public List<CategoryResponse> findAllCategory() {
        List<CategoryResponse> responses = categoryMapper.findAllCategory();
        if(responses.isEmpty()){
            throw new BusinessException("カテゴリがありません");
        }
        return responses;
    }

    //新たなカテゴリ追加
    public CategoryResponse insertCategory(CreateCategoryRequest request){
        CategoryResponse response = categoryMapper.insertCategory(request);
        if(response == null){
            throw new BusinessException("カテゴリ登録に失敗しました");
        }
        return response;
    }
}
