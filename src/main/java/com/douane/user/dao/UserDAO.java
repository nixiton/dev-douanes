package com.douane.user.dao;

import java.util.ArrayList;
import java.util.List;

import com.douane.model.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class UserDAO implements IUserDAO {
	@Autowired
	private SessionFactory entityManagerFactory;

	/**
	 * Get Hibernate Session Factory
	 *
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 *
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.entityManagerFactory = sessionFactory;
    }

	/**
	 * Add User
	 *
	 * @param  User user
	 */
	public void addUser(User user) {
		entityManagerFactory.getCurrentSession().save(user);
	}

	/**
	 * Delete User
	 *
	 * @param  User user
	 */
	public void deleteUser(User user) {
		entityManagerFactory.getCurrentSession().delete(user);
	}

	/**
	 * Update User
	 *
	 * @param  User user
	 */
	public void updateUser(User user) {
		entityManagerFactory.getCurrentSession().update(user);
	}

	/**
	 * Get User
	 *
	 * @param  int User Id
	 * @return User
	 */
	public User getUserById(int id) {
		List list = entityManagerFactory.getCurrentSession()
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
		List list = entityManagerFactory.getCurrentSession().createQuery("from User").list();
		return list;
	}

	/**
	 * Find User
	 *
	 * @param  String User Username
	 * @return User
	 */
	public User findUser(String username) {
		// TODO Auto-generated method stub
		       Query query = entityManagerFactory.getCurrentSession().createQuery("from User u where u.username = :username");
	        query.setParameter("username", username);
	       return (User) query.uniqueResult();
	    }
	

}
