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
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leref == null) ? 0 : leref.hashCode());
		//result = prime * result + ((table == null) ? 0 : table.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Referentiel other = (Referentiel) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leref == null) {
			if (other.leref != null)
				return false;
		} else if (!leref.equals(other.leref))
			return false;
		/*if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;*/
		return true;
	}
	
	
}
