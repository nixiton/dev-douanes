package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class TypeMateriel extends Referentiel{
	public TypeMateriel(){
		this.setTable("TypeMateriel");
	}
	public TypeMateriel(String designation){
		super(designation);
		this.setTable("TypeMateriel");
	}
}

