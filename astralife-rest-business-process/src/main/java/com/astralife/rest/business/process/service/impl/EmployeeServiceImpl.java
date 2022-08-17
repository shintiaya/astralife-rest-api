package com.astralife.rest.business.process.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.EmployeeService;
import com.astralife.rest.persistence.model.Employee;
import com.astralife.rest.persistence.repository.EmployeeRepository;
import com.astralife.rest.service.services.impl.GeneralServiceImpl;

@Service
public class EmployeeServiceImpl extends GeneralServiceImpl<Employee, Long> implements EmployeeService{

	private EmployeeRepository employeeRepository;

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.repository = employeeRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee getByEmpNo(Long empNo) {
		return employeeRepository.findByEmpNo(empNo);
	}

	@Override
	public void deleteByEmpNo(Long empNo) {
		try {
			employeeRepository.deleteByEmpNo(empNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
