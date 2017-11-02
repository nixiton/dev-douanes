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
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.Agent;
import com.douane.entite.Useri;
import com.douane.metier.user.IUserMetier;
import com.douane.model.User;
import com.douane.user.service.IUserService;


@ManagedBean(name="userMB")
@RequestScoped
@Transactional
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	/*//Spring User Service is injected...
	@ManagedProperty(value="#{UserService}")
	IUserService userService;
	*/
	@ManagedProperty(value="#{usermetier}")
	IUserMetier usermetierimpl;
	
	List<Agent> userList;
	
	private int id;
	private String name;
	private String username;
	private String password;
	private Long im;
	  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	/**
	 * Add User
	 * 
	 * @return String - Response Message
	 */
	public String addUser() {
		try {
			Agent user = new Agent();
			//user.setName(getName());
			user.setNomAgent(getName());
			//user.setUsername(getUsername());
			user.setPrenomAgent(getName());
			user.setIm(getIm());
			
			 String hashedPassword = passwordEncoder.encode(getPassword());
			 user.setPassword(hashedPassword);
			//user.setPassword(hashedPassword);
			getUsermetierimpl().addAgent(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		FacesContext.getCurrentInstance().addMessage("myForm:password1", new FacesMessage("Password Doesnt Match"));
		return ERROR;
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
	public List<Agent> getUserList() {
		userList = new ArrayList<Agent>();
		userList.addAll(getUsermetierimpl().findAllAgents());
		return userList;
	}
	
	/**
	 * Get User Service
	 * 
	 * @return IUserService - User Service
	 
	public IUserService getUserService() {
		return userService;
	}

	
	 * Set User Service
	 * 
	 * @param IUserService - User Service
	 
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	 * Set User List
	 * 
	 * @param List - User List
	 */
	public void setUserList(List<Agent> userList) {
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

	/**
	 * Set User Id
	 * 
	 * @param int - User Id
	 */
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
	
	/**
	 * Set User Name
	 * 
	 * @param String - User Name
	 */
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

	public IUserMetier getUsermetierimpl() {
		return usermetierimpl;
	}

	public void setUsermetierimpl(IUserMetier usermetierimpl) {
		this.usermetierimpl = usermetierimpl;
	}

	public Long getIm() {
		return im;
	}

	public void setIm(Long im) {
		this.im = im;
	}
	
	
	
	
}