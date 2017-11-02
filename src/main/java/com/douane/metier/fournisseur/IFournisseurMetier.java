package com.douane.metier.fournisseur;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Fournisseur;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IFournisseurMetier {
	
	
	public Fournisseur addFournisseur(Fournisseur f);
	public void remFournisseur(Fournisseur f);
	
	//temporary
	
	
	public List<Fournisseur> findAllFournisseur();	
	
	 
}
