package com.douane.managed.bean.saisieRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.Bureau;
import com.douane.entite.Fournisseur;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.fournisseur.IFournisseurMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieFournisseurMB")
@RequestScoped
@Transactional
public class SaisieFournisseurMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private List<Fournisseur> fournisseurList;
	
	
	@ManagedProperty(value="#{fournisseurmetier}")
	private IFournisseurMetier fournisseurmetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
					
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setDesignation(designation);
			fournisseurmetierimpl.addFournisseur(fournisseur);
			
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IFournisseurMetier getFournisseurmetierimpl(){
		return this.fournisseurmetierimpl;
	}
	
	public void setFournisseurmetierimpl(IFournisseurMetier n){
		this.fournisseurmetierimpl = n;
	}


	public List<Fournisseur> getfournisseurList() {

		
		this.fournisseurList = new ArrayList<Fournisseur>();
		this.fournisseurList.addAll(getFournisseurmetierimpl().findAllFournisseur());
		
		
		return fournisseurList;
	}

	public void setFournisseurList(List<Fournisseur> f) {
		this.fournisseurList = f;
	}
}
