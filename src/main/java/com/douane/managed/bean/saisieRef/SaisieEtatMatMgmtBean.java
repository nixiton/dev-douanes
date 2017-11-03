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
import com.douane.entite.EtatMateriel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.etatMateriel.IEtatMaterielMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieEtatMatMB")
@RequestScoped
@Transactional
public class SaisieEtatMatMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private List<EtatMateriel> etatmaterielList;
	
	
	@ManagedProperty(value="#{etatmaterielmetier}")
	private IEtatMaterielMetier etatmaterielmetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			
			EtatMateriel etatmateriel = new EtatMateriel();
			etatmateriel.setDesignation(designation);
			etatmaterielmetierimpl.addEtatMateriel(etatmateriel);	
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IEtatMaterielMetier getEtatmaterielmetierimpl(){
		return this.etatmaterielmetierimpl;
	}
	
	public void setEtatmaterielmetierimpl(IEtatMaterielMetier n){
		this.etatmaterielmetierimpl = n;
	}

	public List<EtatMateriel> getEtatmaterielList() {
		
		this.etatmaterielList = new ArrayList<EtatMateriel>();
		
		this.etatmaterielList.addAll(getEtatmaterielmetierimpl().findAllEtatMateriel());
		
		return etatmaterielList;
	}

	public void setEtatmaterielList(List<EtatMateriel> etatmaterielList) {
		this.etatmaterielList = etatmaterielList;
	}
}
