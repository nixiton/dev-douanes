package com.douane.entite;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OpEntree extends Operation{
	private static Long numerochronoe;
	
	@ManyToOne
	@JoinColumn(name="idMat")
	private Materiel mat;
	private String numentree;
	
	static {
		numerochronoe = 1L;
	}
	
	public OpEntree(Date date, Date time, String poste, Agent operateur, Materiel mater) {
		super(date, time, poste, operateur);
		this.setMat(mater);
	}
	public OpEntree() {
		
	}
	public void generateNumEntree() {
		//Date today = new Date();
		
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
		this.numentree="OE "+ numerochronoe+ "/"+mat.getServ().getCodeService()+ "/" +dd+ "/" +mm+ "/" +yy;
	}
	public Materiel getMat() {
		return mat;
	}
	public void setMat(Materiel mat) {
		this.mat = mat;
	}
	public String getNumentree() {
		return this.numentree;
	}
}
