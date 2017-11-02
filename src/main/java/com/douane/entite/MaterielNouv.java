package com.douane.entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("MN")
public class MaterielNouv extends Materiel{
	
	@ManyToOne
	@JoinColumn(name="idModAcq")
	private ModeAcquisition modAcq;
	@ManyToOne
	@JoinColumn(name="idFin")
	private Financement financement;
	@ManyToOne
	@JoinColumn(name="idFourn")
	private Fournisseur fournisseur;
	
	
	private Float montant_facture;
	private String refFacture;
	
	/* MANAGED LATER
	 * Nombre par type
	 * */
	
	public MaterielNouv() {
		// TODO Auto-generated constructor stub
		this.setLeref("Nouveau Matériel");
	}

	public ModeAcquisition getModAcq() {
		return modAcq;
	}

	public void setModAcq(ModeAcquisition modAcq) {
		this.modAcq = modAcq;
	}

	public Financement getFinancement() {
		return financement;
	}

	public void setFinancement(Financement financement) {
		this.financement = financement;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Float getMontant_facture() {
		return montant_facture;
	}

	public void setMontant_facture(Float montant_facture) {
		this.montant_facture = montant_facture;
	}

	public String getRefFacture() {
		return refFacture;
	}

	public void setRefFacture(String refFacture) {
		this.refFacture = refFacture;
	}
	public MaterielNouv(Float pu, String reference, String numSerie, String autre, Nomenclature nomenMat,
			EtatMateriel etat, TypeMateriel caract, Agent dc, ModeAcquisition modAcq,
			Financement financement, Fournisseur fournisseur, Float montant_facture, String refFacture,
			String codif, Marque m) {
		super(pu, reference, numSerie, autre,codif, nomenMat, etat, caract, dc, m);
		this.modAcq = modAcq;
		this.financement = financement;
		this.fournisseur = fournisseur;
		this.montant_facture = montant_facture;
		this.refFacture = refFacture;
		this.setLeref("Nouveaux Matériels");
	}	
	

}
