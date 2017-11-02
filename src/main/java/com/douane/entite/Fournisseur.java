package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Fournisseur extends Referentiel{
	public Fournisseur(){
		this.setTable("Fournisseur");
		this.setLeref("Fournisseur");
	}
	public Fournisseur(String designation){
		super(designation);
		this.setTable("Fournisseur");
		this.setLeref("Forunisseur");
	}
}
