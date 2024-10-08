package com.example.blogapps.services.impls;

import com.example.blogapps.dtos.categoryDtos.CategoryCreateDto;
import com.example.blogapps.dtos.categoryDtos.CategoryHomeDto;
import com.example.blogapps.dtos.categoryDtos.CategoryUpdateDto;
import com.example.blogapps.models.Category;
import com.example.blogapps.repositories.CategoryRepository;
import com.example.blogapps.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
   private ModelMapper modelMapper;

    @Override
    public void addCategory(CategoryCreateDto CategoryCreateDto) {
        Category category = new Category();
        category.setName(CategoryCreateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryUpdateDto CategoryUpdateDto, Long id) {
        Category findCategory = categoryRepository.findById(id).orElseThrow();
        findCategory.setName(CategoryUpdateDto.getName());
        categoryRepository.save(findCategory);

    }

    @Override
    public List<CategoryHomeDto> getAllCategories() {
        List<CategoryHomeDto> categoryList = categoryRepository.
                findAll().stream().
                map(category -> modelMapper.map(category,CategoryHomeDto.class)).toList();
        return categoryList;
    }


    @Override
    public void deleteCategory(Long CategoryId) {

    }

    @Override
    public CategoryUpdateDto findUpdateCategory(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto result = modelMapper.map(category,CategoryUpdateDto.class);
        return result;
    }


    @Override
    public List<CategoryHomeDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryHomeDto> result = categories.stream().map(x -> modelMapper.map(x,CategoryHomeDto.class)).toList();
        return result;
    }

    @Override
    public Category findById(Long categoryId) {
        return null;
    }

    @Override
    public List<CategoryHomeDto> getHomeCategories() {
        return List.of();
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {

    }
}