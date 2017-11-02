package com.douane.metier.typeMateriel;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.TypeMateriel;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface ITypeMaterielMetier {
	
	
	public TypeMateriel addTypeMateriel(TypeMateriel t);
	public void remTypeMateriel(TypeMateriel t);
	
	//temporary
	
	
	public List<TypeMateriel> findAllTypeMateriel();	
	
	 
}
