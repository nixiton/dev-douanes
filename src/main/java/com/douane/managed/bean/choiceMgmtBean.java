package com.douane.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.transaction.annotation.Transactional;


@ManagedBean(name="choiceMB")
@RequestScoped
@Transactional
public class choiceMgmtBean implements Serializable {
	
	private String choiceValue = " ";
	
	public String choisir(){
		return getChoiceValue();
	}

	public String getChoiceValue() {
		return choiceValue;
	}

	public void setChoiceValue(String choiceValue) {
		this.choiceValue = choiceValue;
	}
	
}