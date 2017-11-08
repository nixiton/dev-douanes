package com.douane.entite;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeArt", discriminatorType=DiscriminatorType.STRING,length=4)
public class Article  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idArticle;

    @ManyToOne
    @JoinColumn(name="idcode")
    private CodeArticle codeArticle;

    private Long nombre;

    private boolean validation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="imBeneficiaire")
    private Agent beneficiaire;

    @ManyToOne
    @JoinColumn(name="imDepositaire")
    //@Transient
    private Agent dc;


    public Agent getDc() {
        return dc;
    }

    public void setDc(Agent dc) {
        this.dc = dc;
    }

    public CodeArticle getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(CodeArticle codeArticle) {
        this.codeArticle = codeArticle;
    }

    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }


    public Agent getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Agent beneficiaire) {
        this.beneficiaire = beneficiaire;
    }



}
