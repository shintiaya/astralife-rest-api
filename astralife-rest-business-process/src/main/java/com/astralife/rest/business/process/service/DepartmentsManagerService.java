package com.astralife.rest.business.process.service;

import com.astralife.rest.persistence.model.DepartmentsManager;
import com.astralife.rest.service.services.GeneralService;

public interface DepartmentsManagerService extends GeneralService<DepartmentsManager, Long>{

	DepartmentsManager getByEmpNo(Long empNo);

	void deleteByEmpNo(Long empNo);

}
