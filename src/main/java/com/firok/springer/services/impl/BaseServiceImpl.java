package com.firok.springer.services.impl;

import java.io.Serializable;
import java.util.List;

import com.firok.springer.dao.BaseDao;
import com.firok.springer.services.BaseService;

public abstract  class BaseServiceImpl<T, K extends Serializable> implements BaseService<T, K> {

	protected abstract BaseDao<T, K> getDao();

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	/**
	 * 
	 */
	@Override
	public T find(K k) {
		return getDao().find(k);
	}

	@Override
	public void create(T t) {
		getDao().create(t);
	}

	@Override
	public T update(T t) {
		return getDao().update(t);
	}

	@Override
	public void delete(T t) {
		getDao().delete(t);
		
	}

	@Override
	public void delete(K k) {
		getDao().delete(k);
		
	}
}
