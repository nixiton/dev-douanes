package com.douane.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.douane.model.User;
import com.douane.user.service.IUserService;


@ManagedBean(name="ajaxUserMB")
@RequestScoped
public class AjaxUserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	//Spring User Service is injected...
	@ManagedProperty(value="#{UserService}")
	IUserService userService;
	
	List<User> userList;
	
	private int id;
	private String name;
	private String username;
	private String password;
	  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	/**
	 * Add User
	 * 
	 * @return String - Response Message
	 */
	public void addUser() {
		try {
			User user = new User();
			user.setName(getName());
			user.setUsername(getUsername());
			 String hashedPassword = passwordEncoder.encode(getPassword());
			user.setPassword(hashedPassword);
			getUserService().addUser(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed"));
			
		} 	
			
	}
	
	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
	
		this.setName(null);
		this.setUsername(null);
		this.setPassword(null);
	}
	
	public String backToAddUser(){
		return "backform";
	}
	
	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}
	
	/**
	 * Get User Service
	 * 
	 * @return IUserService - User Service
	 */
	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * Get User Id
	 * 
	 * @return int - User Id
	 */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get User Name
	 * 
	 * @return String - User Name
	 */
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}