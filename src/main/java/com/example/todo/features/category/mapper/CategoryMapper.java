package com.example.todo.features.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.features.category.dto.CategoryResponse;
import com.example.todo.features.category.dto.CreateCategoryRequest;

@Mapper
public interface CategoryMapper {
    // タスク一覧取得
    List<CategoryResponse> findAllCategory();

    //新たなカテゴリを追加
    CategoryResponse insertCategory(CreateCategoryRequest request);
}
