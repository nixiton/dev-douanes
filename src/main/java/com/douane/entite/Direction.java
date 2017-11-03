package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Direction extends Referentiel {

	private String codeDirection;
	
	public Direction() {
		// TODO Auto-generated constructor stub
		this.setLeref("Direction");
	}
	public Direction(String designation, String code){
		this.setDesignation(designation);
		this.setCodeDirection(code);
		this.setLeref("Direction");
	}

	public String getCodeDirection() {
		return codeDirection;
	}

	public void setCodeDirection(String codeDirection) {
		this.codeDirection = codeDirection;
	}
	

}
