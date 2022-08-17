package com.astralife.rest.endpoint.contract.response;


import java.util.Date;

import javax.validation.constraints.NotNull;

public class ReadEmployeeFieldResponse {

	private Long id;
	private Long empNo;
	private Date birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private Date hireDate;
	private Integer salary;
	private Date salaryFromDate;
	private Date salaryToDate;
	private String title;
	private Date titleFromDate;
	private Date titleToDate;
	private String deptNo;
	private Date deptFromDate;
	private Date deptToDate;
	
	
	public Long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getSalaryFromDate() {
		return salaryFromDate;
	}
	public void setSalaryFromDate(Date salaryFromDate) {
		this.salaryFromDate = salaryFromDate;
	}
	public Date getSalaryToDate() {
		return salaryToDate;
	}
	public void setSalaryToDate(Date salaryToDate) {
		this.salaryToDate = salaryToDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTitleFromDate() {
		return titleFromDate;
	}
	public void setTitleFromDate(Date titleFromDate) {
		this.titleFromDate = titleFromDate;
	}
	public Date getTitleToDate() {
		return titleToDate;
	}
	public void setTitleToDate(Date titleToDate) {
		this.titleToDate = titleToDate;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public Date getDeptFromDate() {
		return deptFromDate;
	}
	public void setDeptFromDate(Date deptFromDate) {
		this.deptFromDate = deptFromDate;
	}
	public Date getDeptToDate() {
		return deptToDate;
	}
	public void setDeptToDate(Date deptToDate) {
		this.deptToDate = deptToDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
