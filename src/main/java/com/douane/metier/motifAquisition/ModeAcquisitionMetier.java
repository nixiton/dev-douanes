package com.douane.metier.motifAquisition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.entite.ModeAcquisition;
import com.douane.entite.Nomenclature;
import com.douane.repository.*;
import com.douane.repository.saisieRef.MotifAquisitionRepository;


public class ModeAcquisitionMetier implements IModeAcquisitionMetier{

	@Autowired
	private MotifAquisitionRepository modeAqurepos;
	
	
	@Override
	public ModeAcquisition addModeAcquisition(ModeAcquisition m) {
		modeAqurepos.save(m);
		return m;
	}

	@Override
	public void remModeAcquisition(ModeAcquisition m) {
		modeAqurepos.delete(m);
		
	}

	@Override
	public List<ModeAcquisition> findAllModeAcquisition() {
		return (List<ModeAcquisition>)modeAqurepos.findAll();
	}


}
