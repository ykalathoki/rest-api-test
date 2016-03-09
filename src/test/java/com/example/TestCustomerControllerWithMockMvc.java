package com.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.controller.CustomerController;
import com.example.dto.CustomerDto;

/**
 * Extending abstract class name as {@link Tester}. I am trying to test
 * {@link CustomerController} with {@link MockMvc}.
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
public class TestCustomerControllerWithMockMvc extends Tester {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestCustomerControllerWithMockMvc.class);
	/**
	 * Tests to create customer.
	 */
	// @Test
	public void testToCreateCustomer() throws Exception {
		LOGGER.info("Testing to create customer...");

		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerName("Yuba Raj Kalathoki");
		customerDto.setMobileNumber("9847912345");
		customerDto.setAddress("Lalitpur");

		mockMvc.perform(MockMvcRequestBuilders.post("/customer/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(OBJECT_MAPPER.writeValueAsString(customerDto)))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		LOGGER.info("Tested to create customer.");
	}

	/**
	 * Tests to get customer(s). The test case is to check {@link HttpStatus}
	 * code then only verify response string.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToGetCustomer() throws Exception {
		LOGGER.info("Testing to get customer...");

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/customer/get"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		LOGGER.info("Result: " + result.getResponse().getContentAsString());
		LOGGER.info("Tested to get customer.");
	}

}
