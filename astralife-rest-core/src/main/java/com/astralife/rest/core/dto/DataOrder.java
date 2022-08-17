package com.astralife.rest.core.dto;

import java.util.List;

public class DataOrder {
	private List<String> fieldName;
	private String orderType;
	public List<String> getFieldName() {
		return fieldName;
	}
	public void setFieldName(List<String> fieldName) {
		this.fieldName = fieldName;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
}
