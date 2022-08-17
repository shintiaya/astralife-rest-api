package com.astralife.rest.business.process.service;

import com.astralife.rest.persistence.model.Salaries;
import com.astralife.rest.service.services.GeneralService;

public interface SalariesService extends GeneralService<Salaries, Long>{

	Salaries getByEmpNo(Long empNo);

	void deleteByEmpNo(Long empNo);

}
