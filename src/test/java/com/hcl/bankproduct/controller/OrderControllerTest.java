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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bankproduct.dto.OrderRequestDto;
import com.hcl.bankproduct.service.OrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class OrderControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(OrderControllerTest.class);

	MockMvc mockMvc;

	@InjectMocks
	OrderController orderController;

	@Mock
	OrderServiceImpl orderServiceImpl;
	OrderRequestDto orderRequestDto;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
		orderRequestDto = getOrderRequestDto();
	}

	private OrderRequestDto getOrderRequestDto() {

		return new OrderRequestDto();
	}

	@Test
	public void testCreateOrder() throws Exception {
		logger.info("in testCreateOrder()");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/buy").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(orderRequestDto)))
				.andExpect(status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
