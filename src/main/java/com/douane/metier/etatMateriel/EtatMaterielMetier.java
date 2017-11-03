package com.douane.metier.etatMateriel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.EtatMateriel;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.EtatMaterielRepository;


public class EtatMaterielMetier implements IEtatMaterielMetier{

	@Autowired
	private EtatMaterielRepository etatMatrepos;
	
	
	@Override
	public EtatMateriel addEtatMateriel(EtatMateriel e) {
		etatMatrepos.save(e);
		return e;
	}

	@Override
	public void remEtatMateriel(EtatMateriel e) {
		etatMatrepos.delete(e);
		
	}

	@Override
	public List<EtatMateriel> findAllEtatMateriel() {
		return (List<EtatMateriel>)etatMatrepos.findAll();
	}


}
