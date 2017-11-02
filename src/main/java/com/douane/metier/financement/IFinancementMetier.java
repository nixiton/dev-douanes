package com.douane.metier.financement;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Financement;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IFinancementMetier {
	
	
	public Financement addFinancement(Financement f);
	public void remFinancement(Financement f);
	
	//temporary
	
	
	public List<Financement> findAllFinancement();	
	
	 
}
