package com.astralife.rest.endpoint.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsEmployeeService;
import com.astralife.rest.business.process.service.DepartmentsManagerService;
import com.astralife.rest.business.process.service.DepartmentsService;
import com.astralife.rest.business.process.service.EmployeeService;
import com.astralife.rest.business.process.service.SalariesService;
import com.astralife.rest.business.process.service.TitlesService;
import com.astralife.rest.endpoint.contract.request.UpdateEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.UpdateEmployeeResponse;
import com.astralife.rest.endpoint.validator.UpdateEmployeeValidator;
import com.astralife.rest.persistence.enums.GenderEnum;
import com.astralife.rest.persistence.enums.ReportStatusEnum;
import com.astralife.rest.persistence.model.Departments;
import com.astralife.rest.persistence.model.DepartmentsEmployee;
import com.astralife.rest.persistence.model.DepartmentsManager;
import com.astralife.rest.persistence.model.Employee;
import com.astralife.rest.persistence.model.Salaries;
import com.astralife.rest.persistence.model.Titles;

@Service
public class UpdateEmployeeValidatorImpl implements UpdateEmployeeValidator{

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
	public UpdateEmployeeResponse getResponseUpdate(UpdateEmployeeRequest request) {
	UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		try {			
			//validasi department
			Departments dept = departmentsService.getByDeptNo(request.getDeptNo());
			if(dept==null) {
				response.setEmpNo(request.getEmpNo());
				response.setCode(ReportStatusEnum.CODE_999.getCode());
				response.setDescription(ReportStatusEnum.CODE_999.getDescription());
				return response;
			}
			
			Employee employee = employeeService.getByEmpNo(request.getEmpNo());
			employee.setBirthDate(request.getBirthDate());
			employee.setFirstName(request.getFirstName());
			employee.setLastName(request.getLastName());
			employee.setGender(request.getGender());
			employee.setHireDate(request.getHireDate());
			employeeService.save(employee);
			Salaries salary = salariesServies.getByEmpNo(request.getEmpNo());
			salary.setSalary(request.getSalary());
			salary.setFromDate(request.getSalaryFromDate());
			salary.setToDate(request.getSalaryToDate());
			salariesServies.save(salary);
			Titles titles = titlesService.getByEmpNo(request.getEmpNo());
			titles.setTitle(request.getTitle());
			titles.setFromDate(request.getTitleFromDate());
			titles.setToDate(request.getTitleToDate());
			titlesService.save(titles);
			DepartmentsManager deptM = departmentsManagerService.getByEmpNo(request.getEmpNo());
			deptM.setDepartments(dept);
			deptM.setFromDate(request.getDeptFromDate());
			deptM.setToDate(request.getDeptToDate());
			departmentsManagerService.save(deptM);
			DepartmentsEmployee deptE = departmentsEmployeeService.getByEmpNo(request.getEmpNo());
			deptE.setDepartments(dept);
			deptE.setFromDate(request.getDeptFromDate());
			deptE.setToDate(request.getDeptToDate());
			departmentsEmployeeService.save(deptE);
			
			response.setEmpNo(request.getEmpNo());
			response.setId(employee.getId());
			response.setCode(ReportStatusEnum.CODE_00.getCode());
			response.setDescription(ReportStatusEnum.CODE_00.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

}
