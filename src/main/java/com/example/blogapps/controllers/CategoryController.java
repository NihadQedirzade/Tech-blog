package com.example.blogapps.controllers;


import com.example.blogapps.dtos.categoryDtos.CategoryCreateDto;
import com.example.blogapps.dtos.categoryDtos.CategoryHomeDto;
import com.example.blogapps.services.CategoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class CategoryController {


    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/dashboard/category")
    public String dashboard(Model model) {
        List<CategoryHomeDto> data = categoryService.getHomeCategories();
        model.addAttribute("categories" ,data);
        return "/dashboard/category";
    }
    @GetMapping("/dashboard/category/create")
    public String createCategory() {
        return "/dashboard/category/create";
    }

    @PostMapping("/dashboard/category/create")
    public String createCategory( CategoryCreateDto categoryCreateDto) {
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/dashboard/category";
    }

}
