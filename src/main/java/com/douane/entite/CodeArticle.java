package com.douane.entite;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CodeArticle extends Referentiel{

    @ManyToOne
    @JoinColumn(name="idtypeObj")
    private TypeObjet typeObjet;
    public CodeArticle() {
        super();
        this.setLeref("CodeArticle");
        // TODO Auto-generated constructor stub
    }

    public CodeArticle(String designation, TypeObjet typeObj) {
        super(designation);
        this.setLeref("CodeArticle");
        this.setTypeObjet(typeObj);
        // TODO Auto-generated constructor stub
    }

    public TypeObjet getTypeObjet() {
        return typeObjet;
    }

    public void setTypeObjet(TypeObjet typeObjet) {
        this.typeObjet = typeObjet;
    }


}
