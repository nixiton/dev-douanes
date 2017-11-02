package com.douane.entite;


import javax.persistence.Entity;

@Entity
public class Nomenclature extends Referentiel {
	
	private String nomenclature;

	public String getNomenclature() {
		return nomenclature;
	}

	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}

	public Nomenclature(String des_in, String nomenclature) {
		//this.id = id_in;
		this.designation = des_in;
		this.nomenclature = nomenclature;
		this.setTable("Nomenclature");
		this.setLeref("Nomenclature");
	}

	public Nomenclature() {
		super();
		this.setTable("Nomenclature");
		this.setLeref("Nomenclature");
		// TODO Auto-generated constructor stub
	}
	
	
	
}
