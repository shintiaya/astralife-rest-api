package com.astralife.rest.endpoint.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsEmployeeService;
import com.astralife.rest.business.process.service.DepartmentsManagerService;
import com.astralife.rest.business.process.service.DepartmentsService;
import com.astralife.rest.business.process.service.EmployeeService;
import com.astralife.rest.business.process.service.SalariesService;
import com.astralife.rest.business.process.service.TitlesService;
import com.astralife.rest.endpoint.contract.request.DeleteEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.DeleteEmployeeResponse;
import com.astralife.rest.endpoint.validator.DeleteEmployeeValidator;
import com.astralife.rest.persistence.enums.ReportStatusEnum;

@Service
public class DeleteEmployeeValidatorImpl implements DeleteEmployeeValidator{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SalariesService salariesServies;
	
	@Autowired
	private TitlesService titlesService;
	
	@Autowired
	private DepartmentsService departmentsService;
	
	@Autowired
	private DepartmentsEmployeeService departmentsEmployeeService;
	
	@Autowired
	private DepartmentsManagerService departmentsManagerService;
	
	@Override
	public DeleteEmployeeResponse getResponseDelete(DeleteEmployeeRequest request) {
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		try {
			//delete deptManager
			departmentsManagerService.deleteByEmpNo(request.getEmpNo());
			//delete deptEmp
			departmentsEmployeeService.deleteByEmpNo(request.getEmpNo());
			//delete title
			titlesService.deleteByEmpNo(request.getEmpNo());
			//delete salaries
			salariesServies.deleteByEmpNo(request.getEmpNo());
			//delete employee
			employeeService.deleteByEmpNo(request.getEmpNo());
			
			response.setEmpNo(request.getEmpNo());
			response.setCode(ReportStatusEnum.CODE_00.getCode());
			response.setDescription(ReportStatusEnum.CODE_00.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
