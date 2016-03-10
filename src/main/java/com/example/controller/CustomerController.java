package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerDto;
import com.example.service.CustomerService;

/**
 * Customer controller class.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * Accepts request to create customer.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerDto customerDto) {
		LOGGER.info("Called to create customer.");
		customerService.createCustomer(customerDto);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	/**
	 * Accepts request to get customer(s)
	 */
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllCustomer(){
		LOGGER.info("Called to get customer.");
		List<CustomerDto> customerDtoList=customerService.getAllCustomer();
		return new ResponseEntity<Object>(customerDtoList, HttpStatus.OK);
	}
	
	/**
	 * Accepts request to delete all customer.
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAllCustomer(){
		LOGGER.info("Called to delete all customer.");
		customerService.deleteAllCustomer();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
