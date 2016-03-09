package com.example.entities;

import com.example.dto.CustomerDto;

/**
 * Model builder class.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
public class EntityBuilder {
	/**
	 * Builds model {@link Customer}
	 */
	public static Customer buildCustomer(CustomerDto customerDto) {
		return new Customer.Builder().id(customerDto.getId()).customerName(customerDto.getCustomerName())
				.mobileNumber(customerDto.getMobileNumber()).address(customerDto.getAddress()).build();
	}
}
