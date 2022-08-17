package com.astralife.rest.endpoint.contract.response;

public class UpdateEmployeeResponse extends BaseResponse{
	
	private Long id;
	private Long empNo;
	
	public UpdateEmployeeResponse() {
		super();
	}

	public UpdateEmployeeResponse(String description, String code) {
		super(description, code);
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
