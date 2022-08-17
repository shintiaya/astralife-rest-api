package com.astralife.rest.business.process.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.TitlesService;
import com.astralife.rest.persistence.model.Titles;
import com.astralife.rest.persistence.repository.SalariesRepository;
import com.astralife.rest.persistence.repository.TitlesRepository;
import com.astralife.rest.service.services.impl.GeneralServiceImpl;

@Service
public class TitlesServiceImpl extends GeneralServiceImpl<Titles, Long> implements TitlesService{
	private TitlesRepository titlesRepository;

	@Autowired
	public void setTitlesRepository(TitlesRepository titlesRepository) {
		this.repository = titlesRepository;
		this.titlesRepository = titlesRepository;
	}

	@Override
	public Titles getByEmpNo(Long empNo) {
		return titlesRepository.getByEmpNo(empNo);
	}

	@Override
	public void deleteByEmpNo(Long empNo) {
		try {
			titlesRepository.deleteByEmpNo(empNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
