package com.douane.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MA")
public class ModeAcquisition extends Referentiel{

	public ModeAcquisition() {
		// TODO Auto-generated constructor stub
		this.setTable("MA");
		this.setLeref("Mode d'Acquisition");
	}

	public ModeAcquisition(String designation) {
		super(designation);
		this.setTable("MA");
		this.setLeref("Mode d'Acquisition");
		// TODO Auto-generated constructor stub
	}
	
	
}
