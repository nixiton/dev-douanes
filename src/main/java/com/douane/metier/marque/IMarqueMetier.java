package com.douane.metier.marque;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Marque;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IMarqueMetier {
	
	
	public Marque addMarque(Marque m);
	public void remMarque(Marque m);
	
	//temporary
	
	
	public List<Marque> findAllMarque();	
	
	 
}
