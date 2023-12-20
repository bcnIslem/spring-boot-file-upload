package com.bcnislem.fileupload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnislem.fileupload.models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
