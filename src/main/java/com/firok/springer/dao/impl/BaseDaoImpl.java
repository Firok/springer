package com.firok.springer.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.firok.springer.dao.BaseDao;

public class BaseDaoImpl<T, K extends Serializable> implements BaseDao<T, K> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	private Class<T> type;
	
	
	public BaseDaoImpl() {
	}

	public BaseDaoImpl(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return entityManager.createQuery("SELECT t FROM "+type.getSimpleName()+ " t").getResultList();
	}

	@Override
	public T find(K k) {
		return entityManager.find(type, k);
	}

	@Override
	public void create(T t) {
		entityManager.persist(t);
		
	}

	@Override
	public T update(T t) {
		return entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
		
	}

	@Override
	public void delete(K k) {
		entityManager.remove(find(k));
	}

}
