package com.astralife.rest.business.process.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.SalariesService;
import com.astralife.rest.persistence.model.Salaries;
import com.astralife.rest.persistence.repository.SalariesRepository;
import com.astralife.rest.service.services.impl.GeneralServiceImpl;

@Service
public class SalariesServiceImpl extends GeneralServiceImpl<Salaries, Long> implements SalariesService {

	private SalariesRepository salariesRepository;

	@Autowired
	public void setSalariesRepository(SalariesRepository salariesRepository) {
		this.repository = salariesRepository;
		this.salariesRepository = salariesRepository;
	}

	@Override
	public Salaries getByEmpNo(Long empNo) {
		return salariesRepository.getByEmpNo(empNo);
	}

	@Override
	public void deleteByEmpNo(Long empNo) {
		try {
			salariesRepository.deleteByEmpNo(empNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
