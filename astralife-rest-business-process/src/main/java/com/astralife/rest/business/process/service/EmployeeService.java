package com.astralife.rest.business.process.service;

import com.astralife.rest.persistence.model.Employee;
import com.astralife.rest.service.services.GeneralService;

public interface EmployeeService extends GeneralService<Employee, Long>{

	Employee getByEmpNo(Long empNo);

	void deleteByEmpNo(Long empNo);

}
