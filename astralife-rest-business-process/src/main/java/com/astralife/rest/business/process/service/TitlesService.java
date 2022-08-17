package com.astralife.rest.business.process.service;

import com.astralife.rest.persistence.model.Titles;
import com.astralife.rest.service.services.GeneralService;

public interface TitlesService extends GeneralService<Titles, Long>{

	Titles getByEmpNo(Long empNo);

	void deleteByEmpNo(Long empNo);

}
