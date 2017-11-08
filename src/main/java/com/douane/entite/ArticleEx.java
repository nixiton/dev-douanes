package com.douane.entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AE")
public class ArticleEx extends Article{

    public ArticleEx() {
        super();
        // TODO Auto-generated constructor stub
    }

}
