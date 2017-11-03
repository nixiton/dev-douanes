package com.douane.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.transaction.annotation.Transactional;


@ManagedBean(name="topMenuMB")
@RequestScoped
@Transactional
public class topMenuMgmtBean {
	
	public String goToDashboard(){
		return "dashboard"; 
	}
}
