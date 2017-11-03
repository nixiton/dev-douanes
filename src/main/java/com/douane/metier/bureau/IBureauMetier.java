package com.douane.metier.bureau;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Bureau;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IBureauMetier {
	
	
	public Bureau addBureau(Bureau b);
	public void remBureau(Bureau b);
	
	//temporary
	
	
	public List<Bureau> findAllBureaus();	
	
	 
}
