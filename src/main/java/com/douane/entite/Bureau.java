package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Bureau extends Referentiel {
	private String codeBureau;
	
	public Bureau() {
		this.setLeref("Bureau");
		// TODO Auto-generated constructor stub
	}

	public Bureau(String designation, String code) {
		super(designation);
		setCodeBureau(code);
		this.setLeref("Bureau");
		// TODO Auto-generated constructor stub
	}

	public String getCodeBureau() {
		return codeBureau;
	}

	public void setCodeBureau(String codeBureau) {
		this.codeBureau = codeBureau;
	}
	
	

}
