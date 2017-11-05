package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class TypeObjet extends Referentiel{
	
	String caracteristique;
	public TypeObjet() {
		this.setLeref("TypeObjet");
	}
	
	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}

	public TypeObjet(String designation, String caracteristique) {
		super(designation);
		this.setCaracteristique(caracteristique);
		// TODO Auto-generated constructor stub
	}
	
	
}
