package com.douane.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.douane.model.EtatOperation;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Operation implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	protected Long id;
	
	@Temporal(TemporalType.DATE)
	protected Date date;
	@Temporal(TemporalType.TIME)
	protected Date time;
	
	protected String poste;
	protected String motifretour;

	@ManyToOne
	@JoinColumn(name="idOperateur")
	protected Agent operateur;
	
	@ManyToOne
	@JoinColumn(name="idDirection")
	protected Direction direction;


	@Enumerated(EnumType.STRING)
	protected EtatOperation state;
	
	public Long getId() {
		return id;
	}
	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public Operation(Date date, Date time, String poste, Agent operateur) {
		super();
		this.date = date;
		this.time = time;
		this.poste = poste;
		this.operateur = operateur;
		this.state = EtatOperation.WAITING;
		this.direction = operateur.getDirection();
	}
	public void valider() {
		this.state = EtatOperation.ACCEPTED;
	}
	public void amodifier(String motif) {
		this.motifretour = motif;
		this.state = EtatOperation.MODIF;
	}
	public void arefuser(String motif) {
		this.motifretour = motif;
		this.state = EtatOperation.REFUSED;
	}
	
	public Direction getDirection() {
		return direction;
	}


	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	


	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//For xhtml
	public String getMotifretour() {
		return motifretour;
	}

	public Agent getOperateur() {
		return operateur;
	}


	public EtatOperation getState() {
		return state;
	}
	

}
