package com.example.blogapps.dtos.articleDtos;

import com.example.blogapps.dtos.categoryDtos.CategoryHomeDto;
import lombok.Data;

@Data
public class ArticleHomeDto {
    private  Long id;
    private String title;
    private String description;
    private String author;
    private String photoUrl;
    private CategoryHomeDto category;
}
