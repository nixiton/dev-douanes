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
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieBureauMB")
@RequestScoped
@Transactional
public class SaisieBureauMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private String nomenclature;
	private List<Nomenclature> nomenclatureList;
	
	
	@ManagedProperty(value="#{nomenclaturemetier}")
	private INomenclatureMetier nomenclaturemetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			Nomenclature nomenclature = new Nomenclature();
			nomenclature.setDesignation(getDesignation());
			nomenclature.setNomenclature(getNomenclature());
			
			nomenclaturemetierimpl.addNomenclature(nomenclature);
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public INomenclatureMetier getNomenclaturemetierimpl(){
		return this.nomenclaturemetierimpl;
	}
	
	public void setNomenclaturemetierimpl(INomenclatureMetier n){
		this.nomenclaturemetierimpl = n;
	}

	public String getNomenclature() {
		return nomenclature;
	}

	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}

	public List<Nomenclature> getNomlenclatureList() {
		this.nomenclatureList = new ArrayList<Nomenclature>();
		this.nomenclatureList.addAll(getNomenclaturemetierimpl().findAllNomenclatures());
		
		return nomenclatureList;
	}

	public void setNomlenclatureList(List<Nomenclature> nomlenclatureList) {
		this.nomenclatureList = nomlenclatureList;
	}
}
