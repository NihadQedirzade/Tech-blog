package com.example.blogapps.services.impls;

import com.example.blogapps.dtos.articleDtos.ArticleCreateDto;
import com.example.blogapps.dtos.articleDtos.ArticleDashboardDto;
import com.example.blogapps.dtos.articleDtos.ArticleHomeDto;
import com.example.blogapps.dtos.articleDtos.ArticleUpdateDto;
import com.example.blogapps.models.Article;
import com.example.blogapps.models.Category;
import com.example.blogapps.repositories.ArticleRepository;
import com.example.blogapps.services.ArticleService;
import com.example.blogapps.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void createArticle(ArticleCreateDto articleCreateDto) {

    }

    @Override
    public void addArticle(ArticleCreateDto articleCreateDto) {
        Category findCategory = categoryService.findById(articleCreateDto.getCategoryId());
        Article article = new Article();
        article.setTitle(articleCreateDto.getTitle());
        article.setDescription(articleCreateDto.getDescription());
        article.setAuthor(articleCreateDto.getAuthor());
        article.setPhotoUrl(articleCreateDto.getPhotoUrl());
        article.setCategory(findCategory);
        articleRepository.save(article);

    }

    @Override
    public void updateArticle(ArticleUpdateDto articleUpdateDto, Long id) {
        Category findCategory = categoryService.findById(articleUpdateDto.getCategoryId());
        Article findArticle = articleRepository.findById(id).orElseThrow();
        findArticle.setTitle(articleUpdateDto.getTitle());
        findArticle.setDescription(articleUpdateDto.getDescription());
        findArticle.setAuthor(articleUpdateDto.getAuthor());
        findArticle.setPhotoUrl(articleUpdateDto.getPhotoUrl());
        findArticle.setCategory(findCategory);
        articleRepository.save(findArticle);

    }

    @Override
    public void deleteArticle(Long id) {
        Article findArticle = articleRepository.findById(id).orElseThrow();
        articleRepository.delete(findArticle);

    }

    @Override
    public List<ArticleHomeDto> getAllArticles() {
        List<ArticleHomeDto> articles = articleRepository.findAll()
                .stream()
                .map(article -> modelMapper.map(article, ArticleHomeDto.class))
                .toList();

        return articles;
    }

    @Override
    public List<ArticleDashboardDto> getArticles(){
        List<ArticleDashboardDto> articles = articleRepository.findAll()
                .stream()
                .map(article -> modelMapper.map(article, ArticleDashboardDto.class))
                .toList();
        return articles;
    }

    @Override
    public ArticleUpdateDto findUpdateArticle(Long id) {
        Article findArticle = articleRepository.findById(id).orElseThrow();
        ArticleUpdateDto result = modelMapper.map(findArticle, ArticleUpdateDto.class);
        return result;
    }
}