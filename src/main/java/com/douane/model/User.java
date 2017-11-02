package com.douane.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user", catalog = "douane")
public class User {
	public String username;
	private String name;
	private String password;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password,
				boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	@Id
	@Column(name = "username", unique = true,
			nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "name", unique = true,
			nullable = false, length = 45)
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password",
			nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	/*private int userId;
	private String name;
	private String username;
	private String password;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="USER_ID", unique = true, nullable = false)
	public int getUserId() {
		return userId;
	}
	

	public void setUserId(int id) {
		this.userId = id;
	}

	@Column(name="name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name="USERNAME", unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(getUserId());
		strBuff.append(", name : ").append(getName());
		strBuff.append(", username : ").append(getUsername());
		return strBuff.toString();
	}



	public void setPassword(String password) {
		this.password = password;
	}*/


}
