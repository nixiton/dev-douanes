package com.douane.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.transaction.annotation.Transactional;


@ManagedBean(name="topMenuMB")
@RequestScoped
@Transactional
public class topMenuMgmtBean  implements Serializable {
	
	public String goToDashboard(){
		return "dashboard"; 
	}
}
