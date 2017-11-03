package com.douane.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;


@ManagedBean(name="loginMgmtBean")
@RequestScoped
public class LoginBean {


	private String immatriculation = null;
	    private String password = null;
	    
	    @ManagedProperty(value="#{authenticationManager}")
	    private AuthenticationManager authenticationManager = null;
	    public String login() throws Exception {
	    	FacesMessage message = null;
	        try
			{
	            Authentication request = new UsernamePasswordAuthenticationToken(this.getImmatriculation(), this.getPassword());
	            Authentication result = authenticationManager.authenticate(request);
	            SecurityContextHolder.getContext().setAuthentication(result);
	        } catch (AuthenticationException e) {
	           
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            return "incorrect";
	        }
	        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", this.getImmatriculation());
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        return "correct";
	    }

	    public String cancel() {
	        return null;
	    }
	    
	    public String signUp() {
	        return "success";
	    }

	    public String logout(){
	        SecurityContextHolder.clearContext();
	        return "loggedout";
	    }
	 
	    public AuthenticationManager getAuthenticationManager() {
	        return authenticationManager;
	    }

	    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	    }



	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
}
