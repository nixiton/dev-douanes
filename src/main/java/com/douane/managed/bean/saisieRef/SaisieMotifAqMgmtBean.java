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
import com.douane.entite.ModeAcquisition;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.metier.motifAquisition.IModeAcquisitionMetier;
import com.douane.metier.motifDecharge.IMotifDechargeMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.nomenclature.NomenclatureMetier;
import com.douane.metier.user.IUserMetier;


@ManagedBean(name="saisieMotifAqMB")
@RequestScoped
@Transactional
public class SaisieMotifAqMgmtBean  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String designation;
	private List<ModeAcquisition> motifaqList;
	
	
	@ManagedProperty(value="#{modeacquisitionmetier}")
	private IModeAcquisitionMetier motifaqmetierimpl;
	
	public String getDesignation(){
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String Creer(){
		
		try {
			
			ModeAcquisition motifaq = new ModeAcquisition();
			motifaq.setDesignation(designation);
			
			motifaqmetierimpl.addModeAcquisition(motifaq);
			return "success";
		} catch (DataAccessException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public IModeAcquisitionMetier getMotifaqmetierimpl(){
		return this.motifaqmetierimpl;
	}
	
	public void setMotifaqmetierimpl(IModeAcquisitionMetier n){
		this.motifaqmetierimpl = n;
	}

	public List<ModeAcquisition> getMotifaqList() {
		
		
		this.motifaqList = new ArrayList<ModeAcquisition>();
		this.motifaqList.addAll(getMotifaqmetierimpl().findAllModeAcquisition());
		
		return motifaqList;
	}

	public void setMotifaqList(List<ModeAcquisition> m) {
		this.motifaqList = m;
	}
}
