package com.douane.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.core.style.ToStringCreator;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Referentiel implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	protected Long id;
	
	@Column(name="designation")
	protected String designation;
	
	public String toString(){
		return this.designation;
	}
	
	/*TEMPORARY NOT NEEDED 
	 * @OneToMany(mappedBy="xxxx", fetch=FetchType.LAZY)
	private List<Materiel> materiels;
	*/
	
	
	public Long getId() {
		return id;
	}
	/*public void setId(int id) {
		this.id = id;
	}*/
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Referentiel(String designation) {
		super();
		//this.id
		this.designation = designation;
	}
	public Referentiel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	@Transient
	protected String table;
	@Transient
	protected String leref;

	public String getLeref() {
		return leref;
	}

	public void setLeref(String leref) {
		this.leref = leref;
	}
	
}
