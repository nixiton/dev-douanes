package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.CodeArticle;
import com.douane.entite.TypeObjet;
import com.douane.entite.Useri;

public interface CodeArticleRepository extends CrudRepository<CodeArticle,Long> {
    public List<CodeArticle> findAll();
    public List<CodeArticle> findByTypeObjet(TypeObjet typeobject);
}
