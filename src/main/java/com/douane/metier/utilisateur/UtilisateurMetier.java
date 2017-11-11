package com.douane.metier.utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Agent;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.repository.*;
import com.douane.repository.saisieRef.UtilisateurRepository;


public class UtilisateurMetier implements IUtilisateurMetier{

	@Autowired
	private UtilisateurRepository utilisateurrepos;
	
	
	@Override
	public Useri addUtilisateur(Useri a) {
		utilisateurrepos.save(a);
		return a;
	}

	@Override
	public void remUtilisateur(Useri a) {
		utilisateurrepos.delete(a);
		
	}

	@Override
	public List<Useri> findAllUtilisateur() {
		return (List<Useri>)utilisateurrepos.findAll();
	}

	@Override
	public Useri findById(int id) {
		return utilisateurrepos.findOne(id);
	}


}
