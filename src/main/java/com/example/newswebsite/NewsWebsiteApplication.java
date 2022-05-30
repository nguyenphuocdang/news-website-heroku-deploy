package com.example.newswebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NewsWebsiteApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(NewsWebsiteApplication.class, args);
    }
}
