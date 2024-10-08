package com.example.blogapps.services;

import com.example.blogapps.dtos.categoryDtos.CategoryCreateDto;
import com.example.blogapps.dtos.categoryDtos.CategoryHomeDto;
import com.example.blogapps.dtos.categoryDtos.CategoryUpdateDto;
import com.example.blogapps.models.Category;


import java.util.List;

public interface CategoryService {
    void addCategory(CategoryCreateDto CategoryCreateDto);
    void updateCategory(CategoryUpdateDto CategoryUpdateDto,Long id);
    List<CategoryHomeDto> getAllCategories();
    void deleteCategory(Long CategoryId);
    CategoryUpdateDto findUpdateCategory(Long id);
    List<CategoryHomeDto> getCategories();

    Category findById(Long categoryId);

    List<CategoryHomeDto> getHomeCategories();

    void createCategory(CategoryCreateDto categoryCreateDto);
}
