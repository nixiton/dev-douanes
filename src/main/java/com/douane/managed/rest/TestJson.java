package com.douane.managed.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.google.gson.Gson;
import com.douane.model.User;
import com.douane.user.service.IUserService;

@ManagedBean(name = "testJson")
@RequestScoped
public class TestJson {
	@ManagedProperty(value = "#{UserService}")
	private IUserService userService;

	private List<User> userList;

	public void renderJson() throws IOException {
		
		Gson gson = new Gson();

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.setResponseContentType("application/json");
		externalContext.setResponseCharacterEncoding("UTF-8");

		externalContext.getResponseOutputWriter().write(gson.toJson(getUserList()));
		facesContext.responseComplete();
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public List<User> getUserList() {
		userList = new ArrayList<User>();
		for(User user : getUserService().getUsers()){
			user.setPassword("");
			userList.add(user);
		}
		return userList;
	}


	public IUserService getUserService() {
		return userService;
	}

}
