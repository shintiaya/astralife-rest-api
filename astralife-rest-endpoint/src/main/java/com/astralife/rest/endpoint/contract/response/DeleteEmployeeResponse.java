package com.astralife.rest.endpoint.contract.response;

public class DeleteEmployeeResponse extends BaseResponse{

	private Long empNo;
	
	
	public DeleteEmployeeResponse() {
		super();
	}

	public DeleteEmployeeResponse(String description, String code) {
		super(description, code);
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}
}
