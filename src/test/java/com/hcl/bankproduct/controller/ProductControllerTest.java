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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bankproduct.service.ProductServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	@Mock
	ProductServiceImpl productServiceImpl;
	@InjectMocks
	ProductController productController;
	MockMvc mockMvc;
	private static final Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}
	@Test
	public void getProductsTest() throws Exception {
		logger.info("inside the getProductsTest method");
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getProducts").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
