package com.bcnislem.fileupload.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bcnislem.fileupload.models.Article;
import com.bcnislem.fileupload.services.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public ResponseEntity<String> addArticle (@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("content") String content) throws IOException {
        
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);

        articleService.saveArticle(article, file);

        return ResponseEntity.ok("Article Saved Successfully!");
    }

    @GetMapping
    public ResponseEntity<String> getArticles () {
        return ResponseEntity.ok("RESTful api is working!");
    }
}
