package com.astralife.rest.endpoint.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astralife.rest.endpoint.contract.request.CreateEmployeeRequest;
import com.astralife.rest.endpoint.contract.request.DeleteEmployeeRequest;
import com.astralife.rest.endpoint.contract.request.ReadEmployeeRequest;
import com.astralife.rest.endpoint.contract.request.UpdateEmployeeRequest;
import com.astralife.rest.endpoint.contract.response.BaseResponse;
import com.astralife.rest.endpoint.contract.response.CreateEmployeeResponse;
import com.astralife.rest.endpoint.contract.response.DeleteEmployeeResponse;
import com.astralife.rest.endpoint.contract.response.ReadEmployeeResponse;
import com.astralife.rest.endpoint.contract.response.UpdateEmployeeResponse;
import com.astralife.rest.endpoint.validator.CreateEmployeeValidator;
import com.astralife.rest.endpoint.validator.DeleteEmployeeValidator;
import com.astralife.rest.endpoint.validator.ReadEmployeeValidator;
import com.astralife.rest.endpoint.validator.RequestValidator;
import com.astralife.rest.endpoint.validator.UpdateEmployeeValidator;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/astralife")
public class EmployeeController {
	
	private final Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	private CreateEmployeeValidator createEmployeeValidator;
	
	@Autowired
	private ReadEmployeeValidator readEmployeeValidator;
	
	@Autowired
	private UpdateEmployeeValidator updateEmployeeValidator;
	
	@Autowired
	private DeleteEmployeeValidator deleteEmployeeValidator; 
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/create")
	public ResponseEntity<BaseResponse> create(@RequestBody CreateEmployeeRequest request) {
		log.info("CREATE EMPLOYEE......");
		CreateEmployeeResponse response;
		
		log.info("VALIDATING REQUEST...");
		ResponseEntity<BaseResponse> valid = RequestValidator.validate(request);
		if (valid != null)
			return valid;
		
		log.info("PROCESSING DATA.....");
		response = createEmployeeValidator.getResponseCreate(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/read")
	public ResponseEntity<BaseResponse> read(@RequestBody ReadEmployeeRequest request) {
		log.info("CREATE EMPLOYEE......");
		ReadEmployeeResponse response;
		
		log.info("VALIDATING REQUEST...");
		ResponseEntity<BaseResponse> valid = RequestValidator.validate(request);
		if (valid != null)
			return valid;
		
		log.info("PROCESSING DATA.....");
		response = readEmployeeValidator.getResponseRead(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/update")
	public ResponseEntity<BaseResponse> update(@RequestBody UpdateEmployeeRequest request) {
		log.info("CREATE EMPLOYEE......");
		UpdateEmployeeResponse response;
		
		log.info("VALIDATING REQUEST...");
		ResponseEntity<BaseResponse> valid = RequestValidator.validate(request);
		if (valid != null)
			return valid;
		
		log.info("PROCESSING DATA.....");
		response = updateEmployeeValidator.getResponseUpdate(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/delete")
	public ResponseEntity<BaseResponse> delete(@RequestBody DeleteEmployeeRequest request) {
		log.info("DELETE EMPLOYEE......");
		DeleteEmployeeResponse response;
		
		log.info("VALIDATING REQUEST...");
		ResponseEntity<BaseResponse> valid = RequestValidator.validate(request);
		if (valid != null)
			return valid;
		
		log.info("PROCESSING DATA.....");
		response = deleteEmployeeValidator.getResponseDelete(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
