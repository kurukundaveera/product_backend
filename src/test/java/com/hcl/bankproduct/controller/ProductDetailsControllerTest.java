/**
 * 
 */
package com.hcl.bankproduct.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.bankproduct.repository.ProductRepository;
import com.hcl.bankproduct.service.ProductDetailsServiceImpl;

/**
 * @author Gurpreet Singh
 *
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ProductDetailsControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ProductDetailsControllerTest.class);
	
	 MockMvc mockMvc;
	
	@InjectMocks
	ProductDetailsController productDetailsController;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	ProductDetailsServiceImpl productDetailsServiceImpl;
	
	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(productDetailsController).build();
	}
	
	@Test
	public void testGetProductDetails() throws Exception
	{
		logger.info("in testGetProductDetails()");
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product/{productId}",1)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
