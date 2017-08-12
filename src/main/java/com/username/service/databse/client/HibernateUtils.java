package com.username.service.databse.client;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;

	static {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata metaData = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		sessionFactory =  metaData.getSessionFactoryBuilder().build();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session beginTransaction() {
		Session hSession = HibernateUtils.getSession();
		hSession.beginTransaction();
		return hSession;
	}
	
	public static void commitTransaction() {
		HibernateUtils.getSession().getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		HibernateUtils.getSession().getTransaction().rollback();
	}
	
	public static void closeSession() {
		HibernateUtils.getSession().close();
	}
	
	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

}
