package com.example.newswebsite.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "article")
public class Article {
    @Id
    private String id;

    private String userId;

    private String image;

    private String title;

    private String content;

    private String status;

    private String categoryName;

    private String publishedDate;
}
