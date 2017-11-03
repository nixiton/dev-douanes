package com.douane.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OpAttribution extends Operation{
	
	@ManyToOne
	@JoinColumn(name="idMat")
	private Materiel mat;
	
	@ManyToOne
	@JoinColumn(name="idDetenteur")
	private Agent detenteur;
	private String detenteurEffectif;
	
	public OpAttribution(Date date, Date time, String poste, Agent operateur, Materiel m, Agent det) {
		super(date, time, poste, operateur);
		this.mat = m;
		this.detenteur = det;
		this.setDetenteurEffectif("generated detenteur effectif default");
		
	}
	public OpAttribution() {
		
	}
	
	
	
	public Materiel getMat() {
		return mat;
	}
	public void setMat(Materiel mat) {
		this.mat = mat;
		this.setDetenteurEffectif("generated detenteur effectif Materiel modified");
	}
	
	public Agent getDetenteur() {
		return this.detenteur;
	}
	
	public void setDetenteur(Agent det) {
		this.detenteur = det;
		this.setDetenteurEffectif("generated detenteur effectif detenteur modified");
	}
	public String getDetenteurEffectif() {
		return detenteurEffectif;
	}
	private void setDetenteurEffectif(String detenteurEffectif) {
		this.detenteurEffectif = detenteurEffectif;
	}
	
}
