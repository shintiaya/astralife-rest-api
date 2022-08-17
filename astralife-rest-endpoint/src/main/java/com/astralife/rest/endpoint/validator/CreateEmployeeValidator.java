package com.astralife.rest.endpoint.validator;

import com.astralife.rest.endpoint.contract.request.CreateEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.CreateEmployeeResponse;

public interface CreateEmployeeValidator {

	CreateEmployeeResponse getResponseCreate(CreateEmployeeRequest request);

}
