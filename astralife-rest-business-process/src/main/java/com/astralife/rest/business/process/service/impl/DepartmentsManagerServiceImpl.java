package com.astralife.rest.business.process.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsManagerService;
import com.astralife.rest.persistence.model.DepartmentsManager;
import com.astralife.rest.persistence.repository.DepartmentsManagerRepository;
import com.astralife.rest.persistence.repository.DepartmentsRepository;
import com.astralife.rest.service.services.impl.GeneralServiceImpl;

@Service
public class DepartmentsManagerServiceImpl extends GeneralServiceImpl<DepartmentsManager, Long> implements DepartmentsManagerService{

	private DepartmentsManagerRepository departmentsManagerRepository;

	@Autowired
	public void setDepartmentsManagerRepository(DepartmentsManagerRepository departmentsManagerRepository) {
		this.repository = departmentsManagerRepository;
		this.departmentsManagerRepository = departmentsManagerRepository;
	}

	@Override
	public DepartmentsManager getByEmpNo(Long empNo) {
		return departmentsManagerRepository.getByEmpNo(empNo);
	}

	@Override
	public void deleteByEmpNo(Long empNo) {
		try {
			departmentsManagerRepository.deleteByEmpNo(empNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
