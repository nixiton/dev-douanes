package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class MotifSortie extends Referentiel{
	public MotifSortie(){
		this.setTable("MotifSortie");
	}
	public MotifSortie(String designation){
		super(designation);
		this.setTable("MotifSortie");
		this.setLeref("Motif de Sortie");
	}
}
