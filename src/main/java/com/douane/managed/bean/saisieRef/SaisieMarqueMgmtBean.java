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
import com.douane.entite.Marque;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.marque.IMarqueMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieMarqueMB")
@RequestScoped
@Transactional
public class SaisieMarqueMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private List<Marque> marqueList;
	
	
	@ManagedProperty(value="#{marquemetier}")
	private IMarqueMetier marquemetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {			
			Marque marque = new Marque();
			marque.setDesignation(designation);
			
			marquemetierimpl.addMarque(marque);
			
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IMarqueMetier getMarquemetierimpl(){
		return this.marquemetierimpl;
	}
	
	public void setMarquemetierimpl(IMarqueMetier n){
		this.marquemetierimpl = n;
	}

	public List<Marque> getMarqueList() {
		
		this.marqueList = new ArrayList<Marque>();
		this.marqueList.addAll(getMarquemetierimpl().findAllMarque());
		
		
		return marqueList;
	}

	public void setMarqueList(List<Marque> m) {
		this.marqueList = m;
	}
}
