package com.example.blogapps.services;

import com.example.blogapps.dtos.articleDtos.ArticleCreateDto;
import com.example.blogapps.dtos.articleDtos.ArticleDashboardDto;
import com.example.blogapps.dtos.articleDtos.ArticleHomeDto;
import com.example.blogapps.dtos.articleDtos.ArticleUpdateDto;
import com.example.blogapps.models.Article;

import java.util.List;

public interface ArticleService {
    void createArticle(ArticleCreateDto articleCreateDto);

    void addArticle(ArticleCreateDto articleCreateDto);

    void updateArticle(ArticleUpdateDto articleUpdateDto, Long id);
    List<ArticleHomeDto> getAllArticles();
    void deleteArticle(Long id);

    List<ArticleDashboardDto> getArticles();

    ArticleUpdateDto findUpdateArticle(Long id);
}
