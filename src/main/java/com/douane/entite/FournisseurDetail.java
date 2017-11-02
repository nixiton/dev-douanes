package com.douane.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FournisseurDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFourn;
	
	private String nomFourn;
	private String nif;
	private String stat;
	private String contact;
	private String adresse;
	private String observation;
	
	public Long getIdFourn(){
		return this.idFourn;
	}
	

	public String getNomFourn() {
		return nomFourn;
	}


	public void setNomFourn(String nomFourn) {
		this.nomFourn = nomFourn;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getStat() {
		return stat;
	}


	public void setStat(String stat) {
		this.stat = stat;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public FournisseurDetail() {
		// TODO Auto-generated constructor stub
	}


	public FournisseurDetail(String nomFourn, String nif, String stat, String contact, String adresse,
			String observation) {
		super();
		this.nomFourn = nomFourn;
		this.nif = nif;
		this.stat = stat;
		this.contact = contact;
		this.adresse = adresse;
		this.observation = observation;
		this.setLeref("Fournisseur en détail");
	
	}
	@Transient
	private String leref;

	public String getLeref() {
		return leref;
	}


	public void setLeref(String leref) {
		this.leref = leref;
	}
	

}
