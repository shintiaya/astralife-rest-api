package com.astralife.rest.endpoint.validator;

import com.astralife.rest.endpoint.contract.request.ReadEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.ReadEmployeeResponse;

public interface ReadEmployeeValidator {

	ReadEmployeeResponse getResponseRead(ReadEmployeeRequest request);

}
