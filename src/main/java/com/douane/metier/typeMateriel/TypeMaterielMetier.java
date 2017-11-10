package com.douane.metier.typeMateriel;

import java.util.List;

import com.douane.dao.materiel.IMatDAO;
import com.douane.entite.Materiel;
import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Nomenclature;
import com.douane.entite.TypeMateriel;
import com.douane.repository.*;
import com.douane.repository.saisieRef.TypeMaterielRepository;


public class TypeMaterielMetier implements ITypeMaterielMetier{

	@Autowired
	private TypeMaterielRepository typeMatrepos;
	
	private IMatDAO matDAO;
	@Override
	public TypeMateriel addTypeMateriel(TypeMateriel t) {
		typeMatrepos.save(t);
		return t;
	}

	@Override
	public void remTypeMateriel(TypeMateriel t) {
		typeMatrepos.delete(t);
		
	}



	@Override
	public List<TypeMateriel> findAllTypeMateriel() {
		return (List<TypeMateriel>)typeMatrepos.findAll();
	}

	@Override
	public List<Materiel> getListMaterielByType(Materiel m)
	{

		return matDAO.listMat(m);
	}
}
