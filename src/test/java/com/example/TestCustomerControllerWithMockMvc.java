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
	 * I am using this method to test all my requirement one by one. If you want
	 * to test all methods at a time you cam simply annotate to all methods.
	 * 
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		Long id = 1L;
		CustomerDto customerDto = getCustomerDto();
		customerDto.setId(id);//only to edit :)
		 //testToCreateCustomer(customerDto); // Creates customer
		testToGetCustomer(); // Lists all customer
		// testToDeleteAllCustomer(); // Deletes all customer
		// testToDeleteCustomerById(id); // Deletes customer with given id
//		 testToUpdateCustomer(customerDto);
	}

	/**
	 * Creates customerDto object with new values and returns its object.
	 */
	private CustomerDto getCustomerDto() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerName("Yuba Raj Kalathoki");
		customerDto.setMobileNumber("9847912345");
		customerDto.setAddress("Lalitpur");
		return customerDto;
	}

	/**
	 * Tests to create customer.
	 * <p>
	 * The test case for this is
	 * <code>to check {@link HttpStatus} code. If customer created successfully 
	 * it should return {@link HttpStatus} code 201.</code>
	 * 
	 * @param customerDto
	 * @throws Exception
	 */

	void testToCreateCustomer(CustomerDto customerDto) throws Exception {
		LOGGER.info("Testing to create customer...");

		mockMvc.perform(MockMvcRequestBuilders.post("/customer/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(OBJECT_MAPPER.writeValueAsString(customerDto)))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		LOGGER.info("Tested to create customer.");
	}

	/**
	 * Tests to get customer(s). The test case is to check {@link HttpStatus}
	 * code and verify response.
	 * 
	 * @throws Exception
	 */

	void testToGetCustomer() throws Exception {
		LOGGER.info("Testing to get customer...");

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/customer/get"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		LOGGER.info("Result: " + result.getResponse().getContentAsString());
		LOGGER.info("Tested to get customer.");
	}

	/**
	 * Tests to delete all customer.
	 * <p>
	 * The test case for this is
	 * <code>to check its {@link HttpStatus}. Since if all
	 * customer deleted successfully, it should return {@link HttpStatus} code
	 * 200. So I am checking here whether this method returns this code or not.</code>
	 * 
	 * @throws Exception
	 */

	void testToDeleteAllCustomer() throws Exception {
		LOGGER.info("Testing to deleting all customer.");
		mockMvc.perform(MockMvcRequestBuilders.delete("/customer/delete"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		LOGGER.info("Tested to delete all customer.");
	}

	/**
	 * Tests to delete customer associated with its own id.
	 * <p>
	 * The test case for this is <code>to check its {@link HttpStatus}. Since if
	 * customer deleted successfully with its id, it should return
	 * {@link HttpStatus} code 200. So I am checking here whether this method
	 * returns this code or not.</code>
	 * <p>
	 * Faillure condition(s):
	 * <p>
	 * If there is no customer with this given id. The test should be failed.
	 * <p>
	 * <b>Note:</b> <i>To execute successful test you must give valid customer
	 * id.</i>
	 * 
	 * @param id
	 *            the id can not be null
	 * @throws Exception
	 */

	void testToDeleteCustomerById(Long id) throws Exception {
		LOGGER.info("Testing to delete customer associated with id:" + id);
		mockMvc.perform(MockMvcRequestBuilders.delete("/customer/delete/" + id))
				.andExpect(MockMvcResultMatchers.status().isOk());
		LOGGER.info("Tested to delete customer associated with id:" + id);
	}
	/**
	 * Tests to update customer.
	 * 
	 * @param customerDto
	 * @throws Exception
	 */
	void testToUpdateCustomer(CustomerDto customerDto) throws Exception {
		LOGGER.info("Testing to update/modify customer");
		mockMvc.perform(MockMvcRequestBuilders.put("/customer/edit")
				.contentType(MediaType.APPLICATION_JSON)
				.content(OBJECT_MAPPER.writeValueAsString(customerDto)))
				.andExpect(MockMvcResultMatchers.status().isOk());
		LOGGER.info("Testing to update/modify customer");
	}
}
