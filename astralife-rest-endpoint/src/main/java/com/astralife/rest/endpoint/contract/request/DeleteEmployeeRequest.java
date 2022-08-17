package com.astralife.rest.endpoint.contract.request;

import javax.validation.constraints.NotNull;

public class DeleteEmployeeRequest {
	
	@NotNull
	private Long empNo;

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}
}
