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
import com.douane.entite.Useri;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;
import com.douane.metier.utilisateur.IUtilisateurMetier;


@ManagedBean(name="saisieUtilisateurMB")
@RequestScoped
@Transactional
public class SaisieUtilisateurMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String role;
	private String designation;
	private List<Useri> utilisateurList;
	
	
	@ManagedProperty(value="#{utilisateurmetier}")
	private IUtilisateurMetier utilisateurmetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			
			Useri utilisateur = new Useri();
			utilisateur.setDesignation(designation);
			utilisateur.setRole(role);
			
			utilisateurmetierimpl.addUtilisateur(utilisateur);
			
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IUtilisateurMetier getUtilisateurmetierimpl(){
		return this.utilisateurmetierimpl;
	}
	
	public void setUtilisateurmetierimpl(IUtilisateurMetier n){
		this.utilisateurmetierimpl = n;
	}

	public List<Useri> getUtilisateurList() {
		this.utilisateurList = new ArrayList<Useri>();		
		this.utilisateurList.addAll(getUtilisateurmetierimpl().findAllUtilisateur());
		
		return utilisateurList;
	}

	public void setUtilisateurList(List<Useri> u) {
		this.utilisateurList = u;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
