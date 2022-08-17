package com.astralife.rest.service.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.IterableUtils;

import com.astralife.rest.persistence.enums.StatusEnum;
import com.astralife.rest.persistence.model.BaseModel;
import com.astralife.rest.persistence.repository.GenericRepository;
import com.astralife.rest.service.services.GeneralService;

@Transactional
public abstract class GeneralServiceImpl<T extends BaseModel, R extends Serializable> implements GeneralService<T, R >{
	protected GenericRepository<T, R> repository;
	
	public T save(T entity) {
		entity.setStatus(StatusEnum.LIVE.getName());
		return repository.save(entity);
	}
	@Override
	public  Iterable<T> saveAll(Iterable<T> entity) {
		return repository.saveAll(entity);
	}
	@Override
	public T get(R id) {
		return 	repository.findById(id).orElse(null);
	}

	@Override
	public List<T> getAllLive() {
		return IterableUtils.toList(repository.findByStatus(StatusEnum.LIVE.getName()));
	}
	@Override
	public List<T> getAll(){
		return IterableUtils.toList(repository.findAll());
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void softRemove(R id) {
		T entity = repository.findById(id).get();
		entity.setStatus(StatusEnum.DELETED.getName());
		repository.save(entity);
	}
	@Override
	public void remove(R id) {
		repository.deleteById(id);
	}
	@Override
	public void remove(T entity) {
		repository.delete(entity);
	}
}
