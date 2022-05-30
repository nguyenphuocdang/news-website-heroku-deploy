package com.example.newswebsite.services.article;

import com.example.newswebsite.dtos.ArticleDto;
import com.example.newswebsite.entities.Article;
import com.example.newswebsite.exceptions.DuplicatedValueException;
import com.example.newswebsite.exceptions.NonexistentValueException;
import com.example.newswebsite.repositories.ArticleRepository;
import com.example.newswebsite.utils.ModelMapperSingleton;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticle() throws Exception {
        try{
            return articleRepository.findAllArticle();
        }catch(Exception ex){
            throw new Exception("System error, detail: " + ex);
        }
    }

    @Override
    public Article getOneArticle(String Id) throws NonexistentValueException {
        Optional<Article> article = articleRepository.findArticleById(Id);
        if(article.isEmpty()){
            throw new NonexistentValueException("Article doesn't exist !!!");
        }
        return article.get();
    }

    @Override
    public Article creatingArticle(ArticleDto articleDto) throws DuplicatedValueException {
        Article article = ModelMapperSingleton.getInstance().modelMapper().map(articleDto, Article.class);
        if(articleRepository.findArticleByTitle(article.getTitle()).isPresent()){
            throw new DuplicatedValueException("This title has been used before !!!");
        }
        articleRepository.save(article);
        return article;
    }
}
