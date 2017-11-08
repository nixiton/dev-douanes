package com.douane.entite;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Useri {
	/*public Useri(String designation, String role) {
		super();
		this.designation = designation;
		this.role = role;
	}*/
	public Useri(){
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String designation;
	private String role;

	/*TEMPORARY NOT NEEDED 
	 * @OneToMany(mappedBy="roleAgent", fetch=FetchType.LAZY)
	private List<Agent> agents;
	
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public void addAgentToList(Agent a){
		agents.add(a);
	}*/
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getIdUser(){
		return this.idUser;
	}
	public Useri(String designation, String role) {
		super();
		this.designation = designation;
		this.role = role;
	}
	public Useri(String designation) {
		super();
		this.designation = designation;
	}


		
}
