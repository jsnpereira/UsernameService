package com.username.service.database.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.username.service.databse.client.HibernateUtils;
import com.username.service.utils.LogApp;

public abstract class EntityManagerImpl<T, ID extends Serializable> implements EntityManager<T, Serializable> {
	LogApp logger = new LogApp(this);
	protected Session getSession() {
		return HibernateUtils.getSession();
	}

	public void save(T entity) {
		logger.logInfo("Saving the "+entity.getClass().getName()+" - values: "+entity.toString());
		Session hSession = getSession();
		hSession.saveOrUpdate(entity);
	}

	public void merge(T entity) {
		Session hSession = getSession();
		hSession.merge(entity);
	}

	public void remove(T entity) {
		Session hSession = getSession();
		hSession.delete(entity);
	}

	public List<T> getList(Query query) {
		logger.logInfo("Get the list");
		List<T> t;
		t = (List<T>) query.getResultList();
		logger.logInfo("Got the list has size is: "+t.size());
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class clas) {
		Session hSession = getSession();
		String className = clas.toString().substring(clas.toString().lastIndexOf(".") + 1);
		Query query = hSession.createQuery("from "+className+ " x");
		List<T> entities = query.getResultList();
		logger.logInfo("Find all "+clas.getName()+": "+entities.size());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T findByID(Class clas, String id) {
		Session hSession = getSession();
		logger.logInfo("Find the "+clas.getName()+" with id: "+id);
		return (T) hSession.get(clas, id);
	}

	public T findOne(Query query) {
		T t = (T) query.getSingleResult();
		logger.logInfo("Find one: "+t.toString());
		return t;
	}
}
