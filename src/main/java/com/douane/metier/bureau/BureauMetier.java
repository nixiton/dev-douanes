package com.douane.metier.bureau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.Bureau;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.BureauRepository;
import com.douane.repository.saisieRef.NomenclatureRepository;


public class BureauMetier implements IBureauMetier{

	
	@Autowired
	private BureauRepository bureaurepos;

	@Override
	public Bureau addBureau(Bureau b) {
		
		// TODO Auto-generated method stub
		bureaurepos.save(b);
		return b;
	}

	@Override
	public void remBureau(Bureau b) {
		// TODO Auto-generated method stub
		bureaurepos.delete(b);
	}

	@Override
	public List<Bureau> findAllBureaus() {
		// TODO Auto-generated method stub
		return (List<Bureau>)bureaurepos.findAll();
	}


}
