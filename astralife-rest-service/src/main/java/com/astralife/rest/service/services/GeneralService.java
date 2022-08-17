package com.astralife.rest.service.services;

import java.io.Serializable;
import java.util.List;

import com.astralife.rest.persistence.model.BaseModel;


public interface GeneralService<T extends BaseModel, R extends Serializable> {

	public T save(T entity) ;

	public Iterable<T> saveAll(Iterable<T> entity) ;
	
	public T get(R id) ;
	
	public List<T> getAll();
	
	public List<T> getAllLive();
	
	public Long count() ;

	public void softRemove(R id) ;

	public void remove(R id) ;

	public void remove(T entity) ;
}
