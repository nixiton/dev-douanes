package com.douane.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.douane.entite.Agent;
import com.douane.entite.Operation;
import com.douane.metier.user.IUserMetier;
import com.douane.requesthttp.RequestFilter;

@ManagedBean(name="operationBean")
@RequestScoped
public class OperationBean {
	private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
    @ManagedProperty(value="#{usermetier}")
    IUserMetier usermetierimpl;
    
    

	private List<Operation> mesOperations;
	private Operation operation;


	
	public IUserMetier getUsermetierimpl() {
		return usermetierimpl;
	}

	public void setUsermetierimpl(IUserMetier usermetierimpl) {
		this.usermetierimpl = usermetierimpl;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public List<Operation> getMesOperations() {
		Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
		this.setMesOperations(usermetierimpl.getListOpByOperator(agent));
		return mesOperations;
	}

	public void setMesOperations(List<Operation> mesOperations) {
		this.mesOperations = mesOperations;
	}

}
