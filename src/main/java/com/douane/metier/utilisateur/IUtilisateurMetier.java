package com.douane.metier.utilisateur;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IUtilisateurMetier {
	
	
	public Useri addUtilisateur(Useri a);
	public void remUtilisateur(Useri a);
	
	//temporary
	
	
	public List<Useri> findAllUtilisateur();	
	public Useri findById(int id);
	 
}
