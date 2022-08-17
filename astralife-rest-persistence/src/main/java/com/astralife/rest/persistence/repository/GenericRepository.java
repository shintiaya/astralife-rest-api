package com.astralife.rest.persistence.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.astralife.rest.persistence.model.BaseModel;


@NoRepositoryBean
@Transactional
public interface GenericRepository<T extends BaseModel, PK extends Serializable> extends CrudRepository<T, PK> {
	
	public List<T> findByStatus(String status);


}
