package com.astralife.rest.business.process.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsEmployeeService;
import com.astralife.rest.persistence.model.DepartmentsEmployee;
import com.astralife.rest.persistence.repository.DepartmentsEmployeeRepository;
import com.astralife.rest.persistence.repository.DepartmentsManagerRepository;
import com.astralife.rest.service.services.impl.GeneralServiceImpl;

@Service
public class DepartmentsEmployeeServiceImpl extends GeneralServiceImpl<DepartmentsEmployee, Long> implements DepartmentsEmployeeService{

	private DepartmentsEmployeeRepository departmentsEmployeeRepository;

	@Autowired
	public void setDepartmentsEmployeeRepository(DepartmentsEmployeeRepository departmentsEmployeeRepository) {
		this.repository = departmentsEmployeeRepository;
		this.departmentsEmployeeRepository = departmentsEmployeeRepository;
	}

	@Override
	public void deleteByEmpNo(Long empNo) {
		try {
			departmentsEmployeeRepository.deleteByEmpNo(empNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public DepartmentsEmployee getByEmpNo(Long empNo) {
		return departmentsEmployeeRepository.getByEmpNo(empNo);
	}
}
