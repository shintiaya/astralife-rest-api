package com.astralife.rest.business.process.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsService;
import com.astralife.rest.persistence.model.Departments;
import com.astralife.rest.persistence.repository.DepartmentsRepository;
import com.astralife.rest.persistence.repository.SalariesRepository;
import com.astralife.rest.service.services.impl.GeneralServiceImpl;

@Service
public class DepartmentsServiceImpl extends GeneralServiceImpl<Departments, Long> implements DepartmentsService{

	private DepartmentsRepository departmentsRepository;

	@Autowired
	public void setDepartmentsRepository(DepartmentsRepository departmentsRepository) {
		this.repository = departmentsRepository;
		this.departmentsRepository = departmentsRepository;
	}
	
	@Override
	public Departments getByDeptNo(String deptNo) {
		return departmentsRepository.findByDeptNo(deptNo);
	}

}
