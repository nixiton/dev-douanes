package com.douane.user.service;

import java.util.List;

import com.douane.model.User;


public interface IUserService {
	
	/**
	 * Add User
	 * 
	 * @param  Useri user
	 */
	public void addUser(User user);
	
	/**
	 * Update User
	 * 
	 * @param  Useri user
	 */
	public void updateUser(User user);

	/**
	 * Delete User
	 * 
	 * @param  Useri user
	 */
	public void deleteUser(User user);
	
	/**
	 * Get User
	 * 
	 * @param  int User Id
	 */
	public User getUserById(int id);
	
	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers();
}
