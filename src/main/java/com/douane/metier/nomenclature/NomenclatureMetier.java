package com.douane.metier.nomenclature;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.NomenclatureRepository;


public class NomenclatureMetier implements INomenclatureMetier{

	@Autowired
	private NomenclatureRepository nomrepos;
	
	
	@Override
	public Nomenclature addNomenclature(Nomenclature n) {
		nomrepos.save(n);
		return n;
	}

	@Override
	public void remNomenclature(Nomenclature n) {
		nomrepos.delete(n);
		
	}

	@Override
	public List<Nomenclature> findAllNomenclatures() {
		return (List<Nomenclature>)nomrepos.findAll();
	}


}
