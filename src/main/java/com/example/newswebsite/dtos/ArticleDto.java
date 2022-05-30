package com.example.newswebsite.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private String id;
    private String userId;
    private String image;
    private String title;
    private String content;
    private String status;
    private String categoryName;
    private String publishedDate;
}
