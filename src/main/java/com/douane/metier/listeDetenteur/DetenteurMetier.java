package com.douane.metier.listeDetenteur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Agent;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.repository.*;
import com.douane.repository.saisieRef.ListeDetenteurRepository;


public class DetenteurMetier implements IDetenteurMetier{

	@Autowired
	private ListeDetenteurRepository detenteurrepos;
	
	
	@Override
	public Agent addDetenteur(Agent u) {
		detenteurrepos.save(u);
		return u;
	}

	@Override
	public void remDetenteur(Agent u) {
		detenteurrepos.delete(u);
		
	}

	@Override
	public List<Agent> findAllDetenteur() {
		return (List<Agent>)detenteurrepos.findAll();
	}


}
