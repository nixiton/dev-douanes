package com.douane.metier.fournisseur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Fournisseur;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.FournisseurRepository;


public class FournisseurMetier implements IFournisseurMetier{

	@Autowired
	private FournisseurRepository fournisseurrepos;
	
	
	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		fournisseurrepos.save(f);
		return f;
	}

	@Override
	public void remFournisseur(Fournisseur f) {
		fournisseurrepos.delete(f);
		
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		return (List<Fournisseur>)fournisseurrepos.findAll();
	}


}
