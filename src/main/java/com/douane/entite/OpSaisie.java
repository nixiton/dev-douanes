package com.douane.entite;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class OpSaisie extends Operation{
	private String designationref;
	private Long idRefer;
	
	public String getDesignationref() {
		return designationref;
	}

	public void setDesignationref(String designationref) {
		this.designationref = designationref;
	}

	public OpSaisie() {
		// TODO Auto-generated constructor stub
	}

	public OpSaisie(Date date, Date time, String poste, Agent operateur, String desref, Long idref) {
		super(date, time, poste, operateur);
		this.setDesignationref(desref);
		this.setIdRefer(idref);
		// TODO Auto-generated constructor stub
	}

	public Long getIdRefer() {
		return idRefer;
	}

	public void setIdRefer(Long idRefer) {
		this.idRefer = idRefer;
	}
	
	

}
