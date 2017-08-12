package com.username.service.database.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

public interface EntityManager<T, ID extends Serializable> {
	public void save(T entity);
	public void merge(T entity);
	public void remove(T entity);
	public List<T> getList(Query query);
	public T findOne(Query query);
	public List<T> findAll(Class clas);
	public T findByID(Class clas, String id);
}
