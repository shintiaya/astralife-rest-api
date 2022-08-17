package com.astralife.rest.endpoint.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astralife.rest.business.process.service.DepartmentsEmployeeService;
import com.astralife.rest.business.process.service.DepartmentsManagerService;
import com.astralife.rest.business.process.service.DepartmentsService;
import com.astralife.rest.business.process.service.EmployeeService;
import com.astralife.rest.business.process.service.SalariesService;
import com.astralife.rest.business.process.service.TitlesService;
import com.astralife.rest.endpoint.contract.request.ReadEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.ReadEmployeeFieldResponse;
import com.astralife.rest.endpoint.contract.response.ReadEmployeeResponse;
import com.astralife.rest.endpoint.validator.ReadEmployeeValidator;
import com.astralife.rest.persistence.model.DepartmentsManager;
import com.astralife.rest.persistence.model.Employee;
import com.astralife.rest.persistence.model.Salaries;
import com.astralife.rest.persistence.model.Titles;

@Service
public class ReadEmployeeValidatorImpl implements ReadEmployeeValidator{

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
	public ReadEmployeeResponse getResponseRead(ReadEmployeeRequest request) {
		ReadEmployeeResponse response = new ReadEmployeeResponse();
		try {
			List<ReadEmployeeFieldResponse> listfield = new ArrayList<ReadEmployeeFieldResponse>();
			ReadEmployeeFieldResponse field = new ReadEmployeeFieldResponse();
			if(request.getEmpNo()!=null) {
				Employee emp = employeeService.getByEmpNo(request.getEmpNo());
				field.setId(emp.getId());
				field.setEmpNo(request.getEmpNo());
				field.setBirthDate(emp.getBirthDate());
				field.setFirstName(emp.getFirstName());
				field.setLastName(emp.getLastName());
				field.setGender(emp.getGender());
				field.setHireDate(emp.getHireDate());
				Salaries sal = salariesServies.getByEmpNo(request.getEmpNo());
				field.setSalary(sal.getSalary());
				field.setSalaryFromDate(sal.getFromDate());
				field.setSalaryToDate(sal.getToDate());
				Titles titl = titlesService.getByEmpNo(request.getEmpNo());
				field.setTitle(titl.getTitle());
				field.setTitleFromDate(titl.getFromDate());
				field.setTitleToDate(titl.getToDate());
				DepartmentsManager deptM = departmentsManagerService.getByEmpNo(request.getEmpNo());
				field.setDeptNo(deptM.getDepartments().getDeptNo());
				field.setDeptFromDate(deptM.getFromDate());
				field.setDeptToDate(deptM.getToDate());
				listfield.add(field);
			}else {
				List<Employee> empL = employeeService.getAllLive();
				for(Employee emp : empL) {
					ReadEmployeeFieldResponse a = new ReadEmployeeFieldResponse();
					a.setId(emp.getId());
					a.setEmpNo(emp.getEmpNo());
					a.setBirthDate(emp.getBirthDate());
					a.setFirstName(emp.getFirstName());
					a.setLastName(emp.getLastName());
					a.setGender(emp.getGender());
					a.setHireDate(emp.getHireDate());
					Salaries sal = salariesServies.getByEmpNo(emp.getEmpNo());
					a.setSalary(sal.getSalary());
					a.setSalaryFromDate(sal.getFromDate());
					a.setSalaryToDate(sal.getToDate());
					Titles titl = titlesService.getByEmpNo(emp.getEmpNo());
					a.setTitle(titl.getTitle());
					a.setTitleFromDate(titl.getFromDate());
					a.setTitleToDate(titl.getToDate());
					DepartmentsManager deptM = departmentsManagerService.getByEmpNo(emp.getEmpNo());
					a.setDeptNo(deptM.getDepartments().getDeptNo());
					a.setDeptFromDate(deptM.getFromDate());
					a.setDeptToDate(deptM.getToDate());
					listfield.add(a);
				}
			}
			response.setField(listfield);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
