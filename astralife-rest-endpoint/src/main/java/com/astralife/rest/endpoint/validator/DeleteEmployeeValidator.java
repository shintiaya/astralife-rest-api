package com.astralife.rest.endpoint.validator;

import com.astralife.rest.endpoint.contract.request.DeleteEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.DeleteEmployeeResponse;

public interface DeleteEmployeeValidator {

	DeleteEmployeeResponse getResponseDelete(DeleteEmployeeRequest request);

}
