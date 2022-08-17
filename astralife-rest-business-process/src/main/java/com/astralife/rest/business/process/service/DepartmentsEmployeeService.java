package com.astralife.rest.business.process.service;

import com.astralife.rest.persistence.model.DepartmentsEmployee;
import com.astralife.rest.service.services.GeneralService;

public interface DepartmentsEmployeeService extends GeneralService<DepartmentsEmployee, Long> {

	void deleteByEmpNo(Long empNo);

	DepartmentsEmployee getByEmpNo(Long empNo);

}
