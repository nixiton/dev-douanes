package com.douane.entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(1)
public class MaterielEx extends Materiel {
	
	public MaterielEx() {
		// TODO Auto-generated constructor stub
		this.setLeref("Matériel Existant");
	}

	public MaterielEx(Float pu, String reference, String numSerie, String autre, String codification,
			Nomenclature nomenMat, EtatMateriel etat, TypeMateriel caract, Agent detenteur, Agent dc, Marque m) {
		super(pu, reference, numSerie, autre, codification, nomenMat, etat, caract, dc, m);
		this.setDetenteur(detenteur);
		this.setLeref("Matériel Existant");
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
