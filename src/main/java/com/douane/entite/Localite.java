package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Localite extends Referentiel{

	public Localite() {
		// TODO Auto-generated constructor stub
		this.setLeref("Localite");
	}

	public Localite(String designation) {
		super(designation);
		this.setLeref("Localite");
		// TODO Auto-generated constructor stub
	}
	
	

}
