package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Adresse extends Referentiel {

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String designation) {
		super(designation);
		this.setLeref("Adresse");
		// TODO Auto-generated constructor stub
	}
	
	
}
