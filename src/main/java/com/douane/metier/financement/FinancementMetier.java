package com.douane.metier.financement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Financement;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.FinancementRepository;


public class FinancementMetier implements IFinancementMetier{

	@Autowired
	private FinancementRepository financementrepos;
	
	
	@Override
	public Financement addFinancement(Financement f) {
		financementrepos.save(f);
		return f;
	}

	@Override
	public void remFinancement(Financement f) {
		financementrepos.delete(f);
		
	}

	@Override
	public List<Financement> findAllFinancement() {
		return (List<Financement>)financementrepos.findAll();
	}


}
