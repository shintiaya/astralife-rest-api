package com.astralife.rest.core.exception;

import com.astralife.rest.core.enums.GeneralErrorCodeEnum;

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 928052655723246064L;
	private GeneralErrorCodeEnum generalErrorCodeEnum;
	private int errorType;
	
	public GeneralException(GeneralErrorCodeEnum generalErrorCodeEnum) {
		super(generalErrorCodeEnum.getDefaultMessage());
		this.generalErrorCodeEnum = generalErrorCodeEnum;
	}
	public GeneralException(String message, Throwable cause) {
		super(message, cause);
	}
	public GeneralException(String message) {
		super(message);
	}
	public GeneralException(Throwable cause) {
		super(cause);
	}
	public GeneralErrorCodeEnum getGeneralErrorCodeEnum() {
		return generalErrorCodeEnum;
	}
	public void setGeneralErrorCodeEnum(GeneralErrorCodeEnum mappingErrorCodeEnum) {
		this.generalErrorCodeEnum = mappingErrorCodeEnum;
	}
	public int getErrorType() {
		return errorType;
	}
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}
	

}
