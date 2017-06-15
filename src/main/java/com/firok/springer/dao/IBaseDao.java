package com.firok.springer.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, K extends Serializable> {
	
	List<T> findAll();
	
	T find(K k);
	
	void create(T t);
	
	T update(T t);
	
	void delete(T t);
	
	void delete(K k);
	

}
