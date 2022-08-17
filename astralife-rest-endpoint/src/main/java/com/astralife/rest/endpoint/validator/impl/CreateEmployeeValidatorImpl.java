package com.astralife.rest.endpoint.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsEmployeeService;
import com.astralife.rest.business.process.service.DepartmentsManagerService;
import com.astralife.rest.business.process.service.DepartmentsService;
import com.astralife.rest.business.process.service.EmployeeService;
import com.astralife.rest.business.process.service.SalariesService;
import com.astralife.rest.business.process.service.TitlesService;
import com.astralife.rest.endpoint.contract.request.CreateEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.CreateEmployeeResponse;
import com.astralife.rest.endpoint.validator.CreateEmployeeValidator;
import com.astralife.rest.persistence.enums.GenderEnum;
import com.astralife.rest.persistence.enums.ReportStatusEnum;
import com.astralife.rest.persistence.model.Departments;
import com.astralife.rest.persistence.model.DepartmentsEmployee;
import com.astralife.rest.persistence.model.DepartmentsManager;
import com.astralife.rest.persistence.model.Employee;
import com.astralife.rest.persistence.model.Salaries;
import com.astralife.rest.persistence.model.Titles;
import com.fasterxml.jackson.core.sym.Name;

@Service
public class CreateEmployeeValidatorImpl implements CreateEmployeeValidator{
	
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
	public CreateEmployeeResponse getResponseCreate(CreateEmployeeRequest request) {
		CreateEmployeeResponse response = new CreateEmployeeResponse();
		try {
			//validasi department
			Departments dept = departmentsService.getByDeptNo(request.getDeptNo());
			if(dept==null) {
				response.setEmpNo(request.getEmpNo());
				response.setCode(ReportStatusEnum.CODE_999.getCode());
				response.setDescription(ReportStatusEnum.CODE_999.getDescription());
				return response;
			}
			
			//proses insert tblemployee
			Employee emp = new Employee();
			System.out.println(request.getEmpNo());
			emp.setEmpNo(request.getEmpNo());
			emp.setBirthDate(request.getBirthDate());
			emp.setFirstName(request.getFirstName());
			emp.setLastName(request.getLastName());
			emp.setGender(request.getGender());
			emp.setHireDate(request.getHireDate());
			emp = employeeService.save(emp);

			
			//insert salary
			Salaries sal = new Salaries();
			sal.setEmployee(emp);
			sal.setSalary(request.getSalary());
			sal.setFromDate(request.getSalaryFromDate());
			sal.setToDate(request.getSalaryToDate());
			salariesServies.save(sal);
			
			//insert title
			Titles titl = new Titles();
			titl.setEmployee(emp);
			titl.setTitle(request.getTitle());
			titl.setFromDate(request.getTitleFromDate());
			titl.setToDate(request.getTitleToDate());
			titlesService.save(titl);
			
			
			//insert depart manager / depart employee
			DepartmentsManager deptM = new DepartmentsManager();
			deptM.setDepartments(dept);
			deptM.setEmployee(emp);
			deptM.setFromDate(request.getDeptFromDate());
			deptM.setToDate(request.getDeptToDate());
			departmentsManagerService.save(deptM);
			
			DepartmentsEmployee deptE = new DepartmentsEmployee();
			deptE.setDepartments(dept);
			deptE.setEmployee(emp);
			deptE.setFromDate(request.getDeptFromDate());
			deptE.setToDate(request.getDeptToDate());
			departmentsEmployeeService.save(deptE);
			
			response.setEmpNo(request.getEmpNo());
			response.setCode(ReportStatusEnum.CODE_00.getCode());
			response.setDescription(ReportStatusEnum.CODE_00.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
