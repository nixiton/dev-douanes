package com.douane.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OpEntreeArticle extends Operation{
    private static Long numerochronoea;

    @ManyToOne
    @JoinColumn(name="idArt")
    private Article article;

    static {
        numerochronoea = 1L;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public OpEntreeArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

    public OpEntreeArticle(Date date, Date time, String poste, Agent operateur) {
        super(date, time, poste, operateur);
        // TODO Auto-generated constructor stub
    }

    public OpEntreeArticle(Date date, Date time, String poste, Agent operateur, Article article) {
        super(date, time, poste, operateur);
        this.article = article;
    }


}
