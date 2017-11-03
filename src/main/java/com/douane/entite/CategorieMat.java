package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class CategorieMat extends Referentiel{

	public CategorieMat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieMat(String designation) {
		super(designation);
		this.setLeref("CategorieMat");
		// TODO Auto-generated constructor stub
	}
	
}
