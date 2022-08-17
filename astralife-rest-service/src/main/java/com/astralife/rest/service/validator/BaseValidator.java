package com.astralife.rest.service.validator;

public interface BaseValidator<M> {
	boolean validate(M obj);
}
