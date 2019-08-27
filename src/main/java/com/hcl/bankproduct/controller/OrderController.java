package com.hcl.bankproduct.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankproduct.dto.OrderRequestDto;
import com.hcl.bankproduct.dto.OrderResponseDto;

/**
 * @author DeepikaSivarajan
 *
 */

import com.hcl.bankproduct.service.OrderService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class OrderController {
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	/**
	 * This method is intended to buy a product
	 * 
	 * @param OrderRequestDto is the input request object which includes
	 *                        productId,customerName,mobileNumber,emailId,city,quantity
	 * @return OrderResponseDto which includes message
	 * 
	 */

	@PostMapping("/buy")
	public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		logger.info("creating order {} : ", orderRequestDto.getCustomerName());
		OrderResponseDto orderResponseDto = orderService.createOrder(orderRequestDto);
		return new ResponseEntity<>(orderResponseDto, HttpStatus.CREATED);
	}
}
