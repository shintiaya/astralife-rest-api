package com.astralife.rest.endpoint.validator;

import com.astralife.rest.endpoint.contract.request.UpdateEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.UpdateEmployeeResponse;

public interface UpdateEmployeeValidator {

	UpdateEmployeeResponse getResponseUpdate(UpdateEmployeeRequest request);

}
