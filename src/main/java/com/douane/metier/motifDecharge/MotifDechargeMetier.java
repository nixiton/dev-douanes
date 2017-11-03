package com.douane.metier.motifDecharge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.MotifDecharge;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.MotifDechargeRepository;


public class MotifDechargeMetier implements IMotifDechargeMetier{

	@Autowired
	private MotifDechargeRepository motifDerepos;
	
	
	@Override
	public MotifDecharge addMotifDecharge(MotifDecharge m) {
		motifDerepos.save(m);
		return m;
	}

	@Override
	public void remMotifDecharge(MotifDecharge m) {
		motifDerepos.delete(m);
		
	}

	@Override
	public List<MotifDecharge> findAllMotifDecharge() {
		return (List<MotifDecharge>)motifDerepos.findAll();
	}


}
