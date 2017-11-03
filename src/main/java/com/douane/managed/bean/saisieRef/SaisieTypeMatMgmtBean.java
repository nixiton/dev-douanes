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
import com.douane.entite.TypeMateriel;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.typeMateriel.ITypeMaterielMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieTypeMatMB")
@RequestScoped
@Transactional
public class SaisieTypeMatMgmtBean  implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String designation;
	
	private List<TypeMateriel> typeMaterielList;
	

	@ManagedProperty(value="#{typematerielmetier}")
	private ITypeMaterielMetier typematerielmetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation){
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			
			
			TypeMateriel typemateriel = new TypeMateriel();
			typemateriel.setDesignation(getDesignation());
			
			typematerielmetierimpl.addTypeMateriel(typemateriel);
			
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public ITypeMaterielMetier getTypematerielmetierimpl(){
		return this.typematerielmetierimpl;
	}
	
	public void setTypematerielmetierimpl(ITypeMaterielMetier n){
		this.typematerielmetierimpl = n;
	}

	public List<TypeMateriel> getTypeMaterielList() {
		this.typeMaterielList = new ArrayList<TypeMateriel>();
		
		this.typeMaterielList.addAll(getTypematerielmetierimpl().findAllTypeMateriel());
		
		return typeMaterielList;
	}

	public void setTypeMaterielList(List<TypeMateriel> typeMaterielList) {
		this.typeMaterielList = typeMaterielList;
	}
}
