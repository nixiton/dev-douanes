package com.douane.metier.listeDetenteur;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IDetenteurMetier {
	
	
	public Agent addDetenteur(Agent u);
	public void remDetenteur(Agent u);
	
	//temporary
	
	
	public List<Agent> findAllDetenteur();	
	
	 
}
