package com.douane.metier.motifAquisition;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.ModeAcquisition;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IModeAcquisitionMetier {
	
	
	public ModeAcquisition addModeAcquisition(ModeAcquisition m);
	public void remModeAcquisition(ModeAcquisition m);
	
	//temporary
	
	
	public List<ModeAcquisition> findAllModeAcquisition();	
	
	 
}
