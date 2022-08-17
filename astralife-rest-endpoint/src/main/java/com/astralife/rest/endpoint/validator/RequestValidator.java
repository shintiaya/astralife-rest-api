package com.astralife.rest.endpoint.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.astralife.rest.endpoint.contract.response.BaseResponse;

public class RequestValidator {
	public static <T> ResponseEntity<BaseResponse> validate (T input) {
	    List<String> errors = new ArrayList<>();
	    Set<ConstraintViolation<T>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(input);
	    if (violations.size() > 0) {
	        for (ConstraintViolation<T> violation : violations) {
	            errors.add(violation.getPropertyPath() + " " + violation.getMessage());
	        }
	    }
	    if(!errors.isEmpty()) {
			BaseResponse baseResponse = new BaseResponse();
			baseResponse.setErrors(errors);
			baseResponse.setCode(BaseResponse.getErrorCode());
			return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
	    }
	    return null;
	}
}
