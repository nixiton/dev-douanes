package com.douane.repository;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Article;
import com.douane.entite.CodeArticle;

public interface ArticleRepository extends CrudRepository<Article,Long>{

}