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
import com.douane.entite.Financement;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.financement.IFinancementMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieFinancementMB")
@RequestScoped
@Transactional
public class SaisieFinancementMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private List<Financement> financementList;
	
	
	@ManagedProperty(value="#{financementmetier}")
	private IFinancementMetier financementmetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			
			
			Financement financement = new Financement();
			financement.setDesignation(designation);
			
			financementmetierimpl.addFinancement(financement);
			
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IFinancementMetier getfinancementmetierimpl(){
		return this.financementmetierimpl;
	}
	
	public void setFinancementmetierimpl(IFinancementMetier n){
		this.financementmetierimpl = n;
	}


	public List<Financement> getFinancementList() {
		this.financementList = new ArrayList<Financement>();
		this.financementList.addAll(getfinancementmetierimpl().findAllFinancement());
		
		return financementList;
	}

	public void setfinancementList(List<Financement> financementList) {
		this.financementList = financementList;
	}
}
