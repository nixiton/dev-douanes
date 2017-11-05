package com.douane.managed.bean.saisieRef;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.Agent;
import com.douane.entite.Bureau;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.entite.Useri;
import com.douane.metier.listeDetenteur.IDetenteurMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieListeDetMB")
@RequestScoped
@Transactional
public class SaisieListeDetMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private long im;
	private String nomAgent;
	private String prenomAgent;
	private String password;
	private Useri roleAgent;
	private List<Materiel> matdetenu;
	
	private List<Agent> detenteurList;

	
	
	@ManagedProperty(value="#{detenteurmetier}")
	private IDetenteurMetier detenteurmetierimpl;

	
	public String Creer(){
		
		try {
			
			Agent detenteur = new Agent();
			
			detenteur.setIm(im);
			detenteur.setNomAgent(nomAgent);
			detenteur.setPassword(password);
			detenteur.setPrenomAgent(prenomAgent);
			detenteur.setRoleAgent(roleAgent);
			
			detenteurmetierimpl.addDetenteur(detenteur);
			
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IDetenteurMetier getDetenteurmetierimpl(){
		return this.detenteurmetierimpl;
	}
	
	public void setDetenteurmetierimpl(IDetenteurMetier n){
		this.detenteurmetierimpl = n;
	}


	public List<Agent> getDetenteurList() {		
		this.detenteurList = new ArrayList<Agent>();
		this.detenteurList.addAll(getDetenteurmetierimpl().findAllDetenteur());
		
		return detenteurList;
	}

	public void setDetenteurList(List<Agent> d) {
		this.detenteurList = d;
	}

	public String getNomAgent() {
		return nomAgent;
	}

	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public void setPrenomAgent(String prenomAgent) {
		this.prenomAgent = prenomAgent;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Materiel> getMatdetenu() {
		return matdetenu;
	}

	public void setMatdetenu(List<Materiel> matdetenu) {
		this.matdetenu = matdetenu;
	}

	public Useri getRoleAgent() {
		return roleAgent;
	}

	public void setRoleAgent(Useri roleAgent) {
		this.roleAgent = roleAgent;
	}

	public long getIm() {
		return im;
	}

	public void setIm(long im) {
		this.im = im;
	}
}
