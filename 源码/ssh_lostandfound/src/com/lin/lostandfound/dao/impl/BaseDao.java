package com.lin.lostandfound.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException he) {
			// he.printStackTrace();
			session = sessionFactory.openSession();
		}
		
		return session;
	}
}
