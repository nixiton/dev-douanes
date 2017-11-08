package com.douane.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OpSortieArticle  extends Operation{
    private static Long numerochronosa;

    @ManyToOne
    @JoinColumn(name="idArt")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idBenefi")
    private Agent beneficiaire;

    static {
        numerochronosa = 1L;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Agent getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Agent beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public OpSortieArticle(Date date, Date time, String poste, Agent operateur, Article article, Agent beneficiaire) {
        super(date, time, poste, operateur);
        this.article = article;
        this.beneficiaire = beneficiaire;
    }
    public OpSortieArticle() {

    }


}
