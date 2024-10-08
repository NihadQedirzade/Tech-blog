package com.example.blogapps.dtos.articleDtos;

import lombok.Data;

@Data
public class ArticleUpdateDto {
    private Long id;
    private String title;
    private String description;
    private String author;
    private String photoUrl;
    private Long categoryId;
}
