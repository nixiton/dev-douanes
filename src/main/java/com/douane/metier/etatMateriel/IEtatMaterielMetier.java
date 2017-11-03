package com.douane.metier.etatMateriel;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.EtatMateriel;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IEtatMaterielMetier {
	
	
	public EtatMateriel addEtatMateriel(EtatMateriel e);
	public void remEtatMateriel(EtatMateriel e);
	
	//temporary
	
	
	public List<EtatMateriel> findAllEtatMateriel();	
	
	 
}
