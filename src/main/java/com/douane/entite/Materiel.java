package com.douane.entite;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeMateriels", discriminatorType=DiscriminatorType.INTEGER)
public class Materiel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMateriel;
	
	private Float pu;
	private String reference;
	private String numSerie;
	private String autre;
	//private String codification;
	private boolean validation;
	private String renseignement;
	
	private String code;
	
	private byte[] image;
	
	private String documentPath;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
	
	@ManyToOne
	@JoinColumn(name="idNom")
	private Nomenclature nomenMat;
	@ManyToOne
	@JoinColumn(name="idEtat")
	private EtatMateriel etat;
	@ManyToOne
	@JoinColumn(name="idCateg")
	private CategorieMat categorie;
	
	
	@ManyToOne
	@JoinColumn(name="idCar")
	private TypeMateriel caract;
	@ManyToOne
	@JoinColumn(name="idMarque")
	private Marque marque;
	
	//localisation
	@ManyToOne
	@JoinColumn(name="idDirection")
	private Direction direc;
	@ManyToOne
	@JoinColumn(name="idSevice")
	private Service serv;
	@ManyToOne
	@JoinColumn(name="idBureau")
	private Bureau bureau;
	
	
	
	
	/*@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fourni;
	*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="imDetenteur")
	private Agent detenteur;
	
	@ManyToOne
	@JoinColumn(name="imDepositaire")
	//@Transient
	private Agent dc;

	/*
	 * MANAGE LATER
	Collection Operations
	File documents;
	Photo Blob
	Codification
	List<Agent> Liste des agents detenteurs successifs
	Code Barre
	Localisation
	*/
	
	public Long getIdMateriel(){
		return this.idMateriel;
	}
	public Float getPu() {
		return pu;
	}
	public void setPu(Float pu) {
		this.pu = pu;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	public Nomenclature getNomenMat() {
		return nomenMat;
	}
	public void setNomenMat(Nomenclature nomenMat) {
		this.nomenMat = nomenMat;
	}
	public Agent getDetenteur() {
		return detenteur;
	}
	public void setDetenteur(Agent detenteur) {
		this.detenteur = detenteur;
	}
	public EtatMateriel getEtat() {
		return etat;
	}
	public void setEtat(EtatMateriel etat) {
		this.etat = etat;
	}
	public TypeMateriel getCaract() {
		return caract;
	}
	public void setCaract(TypeMateriel caract) {
		this.caract = caract;
	}
	public Agent getDc() {
		return dc;
	}
	public void setDc(Agent dc) {
		this.dc = dc;
	}

	@Override
	public boolean equals(Object o) {
		/*if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Materiel materiel = (Materiel) o;


		if (!idMateriel.equals(materiel.idMateriel)) return false;

		return leref.equals(materiel.leref);*/
		System.out.println("herherMat");
		if (this.getIdMateriel().equals(((Materiel)o).getIdMateriel()))
			return true;
		return false;

	}

	@Override
	public int hashCode() {
		int result = idMateriel.hashCode();
		result = 31 * result + reference.hashCode();
		result = 31 * result + numSerie.hashCode();
		result = 31 * result + (validation ? 1 : 0);
		result = 31 * result + code.hashCode();
		result = 31 * result + Arrays.hashCode(image);
		result = 31 * result + leref.hashCode();
		return result;
	}

	/*public String getCodification() {
            return codification;

        }
        public void setCodification(String codification) {
            this.codification = codification;
        }*/
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
	public Materiel(Float pu, String reference, String numSerie, String autre, String codification,
			Nomenclature nomenMat, EtatMateriel etat, TypeMateriel caract, Agent dc, Marque m) {
		super();
		this.pu = pu;
		this.reference = reference;
		this.numSerie = numSerie;
		this.autre = autre;
		//this.codification = codification;
		this.nomenMat = nomenMat;
		this.etat = etat;
		this.caract = caract;
		this.dc = dc;
		this.marque = m;
		setValidation(false);
	}
	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Transient
	protected String leref;


	public String getLeref() {
		return leref;
	}
	public void setLeref(String leref) {
		this.leref = leref;
	}
	public boolean isValidation() {
		return validation;
	}
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public Direction getDirec() {
		return direc;
	}
	public void setDirec(Direction direc) {
		this.direc = direc;
	}
	public Service getServ() {
		return serv;
	}
	public void setServ(Service serv) {
		this.serv = serv;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public String getCode() {
		return code;
	}
/*	
	public Fournisseur getFourni() {
		return fourni;
	}
	public void setFourni(Fournisseur fourni) {
		this.fourni = fourni;
	}
	*/
	public void generateCode() {
		this.code = "Type"+"..."+
					"Bureau"+this.bureau.getCodeBureau()+
					"Acquisition"+"??problemMatExist??"+
					"Origine"+"??problemMatExist??";
	}
	public CategorieMat getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieMat categorie) {
		this.categorie = categorie;
	}
	public String getRenseignement() {
		return renseignement;
	}
	public void setRenseignement(String renseignement) {
		this.renseignement = renseignement;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	
	
	
}
