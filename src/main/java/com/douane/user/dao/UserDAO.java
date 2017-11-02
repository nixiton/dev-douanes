package com.douane.user.dao;

import java.util.ArrayList;
import java.util.List;

import com.douane.model.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;



public class UserDAO implements IUserDAO {
	
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/**
	 * Add User
	 * 
	 * @param  Useri user
	 */
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	/**
	 * Delete User
	 * 
	 * @param  Useri user
	 */
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	/**
	 * Update User
	 * 
	 * @param  Useri user
	 */
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	/**
	 * Get User
	 * 
	 * @param  int User Id
	 * @return User 
	 */
	public User getUserById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from User where id=?")
									        .setParameter(0, id).list();
		return (User)list.get(0);
	}

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers() {
		List list = getSessionFactory().getCurrentSession().createQuery("from User").list();
		return list;
	}

	public User findUser(String username) {
		// TODO Auto-generated method stub
		       Query query = getSessionFactory().getCurrentSession().createQuery("from User u where u.username = :username");
	        query.setParameter("username", username);
	       return (User) query.uniqueResult();
	    }
	

}
