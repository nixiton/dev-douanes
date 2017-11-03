package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Marque extends Referentiel{
	public Marque(){
		this.setTable("Marque");
		this.setLeref("Marque");
	}
	public Marque(String designation){
		super(designation);
		this.setTable("Marque");
		this.setLeref("Marque");
	}
}
