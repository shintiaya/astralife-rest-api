package com.astralife.rest.business.process.service;

import com.astralife.rest.persistence.model.Departments;
import com.astralife.rest.service.services.GeneralService;

public interface DepartmentsService extends GeneralService<Departments, Long>{

	Departments getByDeptNo(String deptNo);

}
