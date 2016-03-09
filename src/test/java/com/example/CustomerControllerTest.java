package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.example.dto.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Customer controller class which handles <code>request</code> and
 * <code>response</code> for client.
 * <p>
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0, Feb 26, 2016
 * @since 0.1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestApiTestApplication.class)
@WebAppConfiguration
public class CustomerControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerTest.class);

	public static final String CONTEXT_PATH = "/rest/api/v1";
	public static final String BASE_URI = "http://localhost:8080";

	// to Generate JSON content from Java objects
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	// Test RestTemplate to invoke the APIs.
	private RestTemplate restTemplate = new TestRestTemplate();

	/**
	 * Test to create customer. If customer is successfully created then it
	 * should return status code 201.
	 * 
	 * @throws URISyntaxException
	 * @throws JsonProcessingException
	 */
	@Test
	public void createCustomer() throws URISyntaxException, JsonProcessingException {
		LOGGER.info("Testing to create customer....");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerName("Yuba Raj Kalathoki");
		customerDto.setMobileNumber("9847912345");
		customerDto.setAddress("Kathmandu");

//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		RequestEntity<CustomerDto> request = RequestEntity.post(new URI(BASE_URI + CONTEXT_PATH + "/customer/create"))
				.body(customerDto);
		ResponseEntity<CustomerDto> response = restTemplate.exchange(request, CustomerDto.class);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

		// LOGGER.info(OBJECT_MAPPER.writeValueAsString(response.getBody()));
		LOGGER.info("Tested to create customer.");
	}

	@Test
	public void listCustomers() throws URISyntaxException, JsonProcessingException {
		LOGGER.info("Testing to get customer(s)....");
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		RequestEntity request = RequestEntity.get(new URI(BASE_URI + CONTEXT_PATH + "/customer/get"))
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//		LOGGER.info(OBJECT_MAPPER.writeValueAsString(response));
		
//		LOGGER.info(response.toString());
		LOGGER.info("Tested to get customer(s).");
	}
}
