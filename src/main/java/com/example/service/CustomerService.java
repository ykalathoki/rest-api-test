
package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerDto;
import com.example.dto.DtoBuilder;
import com.example.entities.Customer;
import com.example.entities.ModelBuilder;
import com.example.repository.CustomerRepository;

/**
 * Customer service class that includes business logics for customer.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
@Service
public class CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Creates {@link Customer}
	 * 
	 * @param customer
	 * @return Newly created customer as customer dto.
	 */
	public CustomerDto createCustomer(CustomerDto customerDto) {
		LOGGER.info("Creating Customer...");
		Customer customer = ModelBuilder.buildCustomer(customerDto);
		Customer newCustomer = customerRepository.save(customer);
		CustomerDto newCustomerDto = DtoBuilder.buildCustomerDto(newCustomer);
		return newCustomerDto;
	}

	/**
	 * Finds all customer.
	 */
	public List<CustomerDto> getAllCustomer() {
		LOGGER.info("Getting Customer...");
		List<Customer> customerList = customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		for (Customer c : customerList) {
			CustomerDto customerDto = DtoBuilder.buildCustomerDto(c);
			customerDtoList.add(customerDto);
		}
		return customerDtoList;
	}
}
