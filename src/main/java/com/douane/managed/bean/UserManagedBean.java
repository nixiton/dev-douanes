package com.douane.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.douane.metier.referentiel.IRefMetier;
import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.Agent;
import com.douane.entite.Bureau;
import com.douane.entite.Direction;
import com.douane.entite.Poste;
import com.douane.entite.Service;
import com.douane.entite.Useri;
import com.douane.metier.user.IUserMetier;
import com.douane.model.User;



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



	@ManagedProperty(value="#{refmetier}")
	IRefMetier refmetierimpl;


	List<Agent> userList;
	
	private int id;
	private String name;
	private String firstname;
	private String password;
	private Long im;
	private String role;
	
	private Useri roleuser;
	private Poste poste;
	
	
	private String designation;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private Direction direction;
	private Service service;
	private Bureau bureau;
	/**
	 * Add User
	 * 
	 * @return String - Response Message
	 */
	public String addUser() {
		try {
			Agent user = new Agent();
			Useri useri = new Useri();
			//user.setName(getName());

			user.setNomAgent(getName());

			//user.setUsername(getUsername());

			user.setPrenomAgent(this.getFirstname());
			user.setIm(getIm());
			
			String hashedPassword = passwordEncoder.encode(getPassword());
			user.setPassword(hashedPassword);
			user.setPassword(hashedPassword);
			useri.setDesignation(designation);
			useri.setRole(role);
			user.setRoleAgent(useri);
			user.setDirection(direction);
			user.setBureau(getBureau());
			user.setService(getService());
			user.setPosteny(getPoste());
			//getUsermetierimpl().addAgent(user);
			//refmetierimpl.addRef(new Useri(designation,role), new Agent(getIm(),getName(),hashedPassword,new Useri(designation,role)));
			//refmetierimpl.addRef(useri,user);
			usermetierimpl.addUser(useri);
			usermetierimpl.addAgent(user);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		FacesContext.getCurrentInstance().addMessage("myForm:password1", new FacesMessage("Password Doesnt Match"));
		return ERROR;
	}
	
	public String addAgent() {
		try {
			Agent user = new Agent();
			//Useri useri = new Useri();
			//user.setName(getName());

			user.setNomAgent(getName());

			//user.setUsername(getUsername());

			user.setPrenomAgent(this.getFirstname());
			user.setIm(getIm());
			
			String hashedPassword = passwordEncoder.encode(getPassword());
			user.setPassword(hashedPassword);
			user.setPassword(hashedPassword);
			//useri.setDesignation(designation);
			//useri.setRole(role);
			user.setRoleAgent(this.getRoleuser());
			user.setDirection(direction);
			user.setBureau(getBureau());
			user.setService(getService());
			user.setPosteny(getPoste());
			//getUsermetierimpl().addAgent(user);
			//refmetierimpl.addRef(new Useri(designation,role), new Agent(getIm(),getName(),hashedPassword,new Useri(designation,role)));
			//refmetierimpl.addRef(useri,user);
			usermetierimpl.addAgent(user);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		FacesContext.getCurrentInstance().addMessage("myForm:password1", new FacesMessage("Password Doesnt Match"));
		return ERROR;
	}


	public String addUserRef() {
		try {
			Agent user = new Agent();
			Useri useri = new Useri();
			//user.setName(getName());

			user.setNomAgent(getName());

			//user.setUsername(getUsername());

			user.setPrenomAgent(getFirstname());
			user.setIm(getIm());
			
			String hashedPassword = passwordEncoder.encode(getPassword());
			user.setPassword(hashedPassword);
			user.setPassword(hashedPassword);
			useri.setDesignation(designation);
			useri.setRole(role);
			user.setRoleAgent(useri);
			user.setDirection(direction);
			//getUsermetierimpl().addAgent(user);
			//refmetierimpl.addRef(new Useri(designation,role), new Agent(getIm(),getName(),hashedPassword,new Useri(designation,role)));
			//refmetierimpl.addRef(useri,user);
			usermetierimpl.addUser(useri);
			usermetierimpl.addAgent(user);

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
		this.setFirstname(null);
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
	 * Get User Direction
	 * 
	 * @return Direction - User direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Set User direction
	 * 
	 * @param Direction - User direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
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


	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public IRefMetier getRefmetierimpl() {
		return refmetierimpl;
	}

	public void setRefmetierimpl(IRefMetier refmetierimpl) {
		this.refmetierimpl = refmetierimpl;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public Poste getPoste() {
		return poste;
	}


	public void setPoste(Poste poste) {
		this.poste = poste;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public Bureau getBureau() {
		return bureau;
	}


	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}


	public Useri getRoleuser() {
		return roleuser;
	}


	public void setRoleuser(Useri roleuser) {
		this.roleuser = roleuser;
	}
	
}
