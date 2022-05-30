package com.example.newswebsite.services.article;

import com.example.newswebsite.dtos.ArticleDto;
import com.example.newswebsite.entities.Article;
import com.example.newswebsite.exceptions.DuplicatedValueException;
import com.example.newswebsite.exceptions.NonexistentValueException;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle() throws Exception;
    Article getOneArticle(String Id) throws NonexistentValueException;
    Article creatingArticle(ArticleDto articleDto) throws DuplicatedValueException;
}
