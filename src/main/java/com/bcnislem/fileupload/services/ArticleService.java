package com.bcnislem.fileupload.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bcnislem.fileupload.models.Article;
import com.bcnislem.fileupload.repositories.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public void saveArticle(Article article, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        fileStorageService.saveFile(fileName, file);

        // set the file name on the article object and save it
        article.setImage(fileName);

        articleRepository.save(article);
    }
    
}
