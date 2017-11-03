package com.douane.metier.nomenclature;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface INomenclatureMetier {
	
	
	public Nomenclature addNomenclature(Nomenclature n);
	public void remNomenclature(Nomenclature n);
	
	//temporary
	
	
	public List<Nomenclature> findAllNomenclatures();	
	
	 
}
