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
import com.douane.entite.MotifDecharge;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.motifDecharge.IMotifDechargeMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieMotifDeMB")
@RequestScoped
@Transactional
public class SaisieMotifDeMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private List<MotifDecharge> motifdeList;
	
	
	@ManagedProperty(value="#{motifdechargemetier}")
	private IMotifDechargeMetier motifdemetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			
			MotifDecharge motifde = new MotifDecharge();
			motifde.setDesignation(designation);
			
			motifdemetierimpl.addMotifDecharge(motifde);
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IMotifDechargeMetier getMotifdemetierimpl(){
		return this.motifdemetierimpl;
	}
	
	public void setMotifdemetierimpl(IMotifDechargeMetier n){
		this.motifdemetierimpl = n;
	}

	public List<MotifDecharge> getMotifdeList() {

		
		this.motifdeList = new ArrayList<MotifDecharge>();
		this.motifdeList.addAll(getMotifdemetierimpl().findAllMotifDecharge());
		
		
		return motifdeList;
	}

	public void setMotifdeList(List<MotifDecharge> m) {
		this.motifdeList = m;
	}
}
