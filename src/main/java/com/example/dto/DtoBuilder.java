package com.example.dto;
import com.example.entities.Customer;

/**
 * DTO builder class. It converts model class to dto.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
public class DtoBuilder {
	/**
	 * Builds {@link CustomerDto}
	 */
	public static CustomerDto buildCustomerDto(Customer customer) {
		return new CustomerDto.Builder().id(customer.getId())
				.customerName(customer.getCustomerName())
				.mobileNumber(customer.getMobileNumber())
				.address(customer.getAddress()).build();
	}

}
