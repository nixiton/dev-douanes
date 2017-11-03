package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Poste extends Referentiel{
		
	public Poste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poste(String designation) {
		super(designation);
		this.setLeref("Poste");
		// TODO Auto-generated constructor stub
	}
	
}
