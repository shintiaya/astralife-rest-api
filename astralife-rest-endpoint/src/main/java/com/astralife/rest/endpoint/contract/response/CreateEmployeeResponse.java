package com.astralife.rest.endpoint.contract.response;

import java.sql.Date;

public class CreateEmployeeResponse extends BaseResponse{
	
	private Long empNo;
	
	
	public CreateEmployeeResponse() {
		super();
	}

	public CreateEmployeeResponse(String description, String code) {
		super(description, code);
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}
	
	

}
