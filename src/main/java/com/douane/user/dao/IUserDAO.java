package com.douane.user.dao;

import java.util.List;

import com.douane.model.User;
import org.springframework.transaction.annotation.Transactional;


public interface IUserDAO {

	/**
	 * Add User
	 * 
	 * @param  User user
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
	 * @param  User user
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
	 */
	public List<User> getUsers();

	/**
	 * Find User
	 *
	 * @param  String User Username
	 */
	public User findUser(String username);
}
