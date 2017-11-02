package com.douane.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OpDettachement extends Operation{
	
	@ManyToOne
	@JoinColumn(name="idMat")
	private Materiel mat;
	
	@ManyToOne
	@JoinColumn(name="idDetenteur")
	private Agent detenteur;
	
	@ManyToOne
	@JoinColumn(name="idMotifS")
	private MotifSortie motifS;
	
	public MotifSortie getMotifS() {
		return motifS;
	}
	public void setMotifS(MotifSortie motifS) {
		this.motifS = motifS;
	}
	public OpDettachement(Date date, Date time, String poste, Agent operateur, Materiel m, Agent det) {
		super(date, time, poste, operateur);
		this.mat = m;
		this.detenteur = det;
		
	}
	public OpDettachement() {
		
	}
	
	
	
	public Materiel getMat() {
		return mat;
	}
	public void setMat(Materiel mat) {
		this.mat = mat;
	}
	
	public Agent getDetenteur() {
		return this.detenteur;
	}
	
	public void setDetenteur(Agent det) {
		this.detenteur = det;
	}
	
	
}
