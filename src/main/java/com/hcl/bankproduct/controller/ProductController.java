package com.hcl.bankproduct.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankproduct.dto.ProductResponseDto;
import com.hcl.bankproduct.service.ProductService;

/**
 * @author Venkat
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;

	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductResponseDto>> getProducts() {
		logger.info("inside the getProducts method in ProductController");
		List<ProductResponseDto> response = productService.getAllProducts();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
