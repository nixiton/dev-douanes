package com.douane.metier.marque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Marque;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.MarqueRepository;


public class MarqueMetier implements IMarqueMetier{

	@Autowired
	private MarqueRepository marquerepos;
	
	
	@Override
	public Marque addMarque(Marque m) {
		marquerepos.save(m);
		return m;
	}

	@Override
	public void remMarque(Marque m) {
		marquerepos.delete(m);
		
	}

	@Override
	public List<Marque> findAllMarque() {
		return (List<Marque>)marquerepos.findAll();
	}


}
