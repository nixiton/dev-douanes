package com.douane.entite;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OpSortie extends Operation{
	private static Long numerochronos;
	
	
	@ManyToOne
	@JoinColumn(name="idMat")
	private Materiel mat;
	private String numSortie;
	@ManyToOne
	@JoinColumn(name="idDirect")
	private Direction direc;
	@ManyToOne
	@JoinColumn(name="idServ")
	private Service serv;
	@ManyToOne
	@JoinColumn(name="idBureau")
	private Bureau bureau;
	@ManyToOne
	@JoinColumn(name="idMotif")
	private MotifSortie motifsortie;
	//String motifnonaccept;
	
	static {
		numerochronos = 1L;
	}
	
	public OpSortie(Date date, Date time, String poste, Agent operateur, 
			Materiel mater, Direction d, Service s, Bureau b, MotifSortie mot) {
		super(date, time, poste, operateur);
		this.setMat(mater);
		this.setDirection(d);
		this.setService(s);
		this.setBureau(b);
		this.setMotifSortie(mot);
	}

	public Materiel getMat() {
		return mat;
	}

	public void setMat(Materiel mat) {
		this.mat = mat;
	}

	public String getNumSortie() {
		return numSortie;
	}

	public void generateNumSortie() {
		int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH); String dd="x";
	    int m = Calendar.getInstance().get(Calendar.MONTH); String mm="x";
	    int y = Calendar.getInstance().get(Calendar.YEAR); String yy="x";
	    if(d < 10){
	      dd="0"+d;
	    }else {
	    	dd=""+d;
	    }
	    if(m < 10){
	       mm="0"+m;
	    }else {
	    	mm=""+m;
	    }
		yy=""+y%200; 
		
		this.numSortie="OS "+ numerochronos+ "/"+mat.getServ().getCodeService()+ "/" +dd+ "/" +mm+ "/" +yy;

	}

	public Direction getDirec() {
		return direc;
	}

	public void setDirection(Direction direc) {
		this.direc = direc;
	}

	public Service getServ() {
		return serv;
	}

	public void setService(Service serv) {
		this.serv = serv;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public MotifSortie getMotif() {
		return motifsortie;
	}

	public void setMotifSortie(MotifSortie motif) {
		this.motifsortie = motif;
	}

	public OpSortie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public String getMotifnonaccept() {
		return motifnonaccept;
	}

	public void setMotifnonaccept(String motifnonaccept) {
		this.motifnonaccept = motifnonaccept;
	}*/
	
	
	
	
}
