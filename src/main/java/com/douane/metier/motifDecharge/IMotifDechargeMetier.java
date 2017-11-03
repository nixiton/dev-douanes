package com.douane.metier.motifDecharge;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.MotifDecharge;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IMotifDechargeMetier {
	
	
	public MotifDecharge addMotifDecharge(MotifDecharge m);
	public void remMotifDecharge(MotifDecharge m);
	
	//temporary
	
	
	public List<MotifDecharge> findAllMotifDecharge();	
	
	 
}
