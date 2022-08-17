package com.astralife.rest.endpoint.contract.response;

import java.util.List;

public class ReadEmployeeResponse extends BaseResponse{

	private List<ReadEmployeeFieldResponse> field;

	public List<ReadEmployeeFieldResponse> getField() {
		return field;
	}

	public void setField(List<ReadEmployeeFieldResponse> field) {
		this.field = field;
	}
	
	
}
