package com.douane.user.dao;

import com.douane.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hasina on 10/11/17.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {


    private SessionFactory entityManagerFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
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


    private Session getCurrentSession() {
        return entityManagerFactory.getCurrentSession();
    }

    public Role getRole(int id) {
        Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
    }


}
