/**
 * 
 */
package com.hcl.bankproduct.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankproduct.dto.ProductDetailsResponseDto;
import com.hcl.bankproduct.service.ProductDetailsServiceImpl;

/**
 * @author Gurpreet Singh
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(ProductDetailsController.class);

	@Autowired
	ProductDetailsServiceImpl productDetailsServiceImpl;

	/**
	 * This method is use to provide the product details by productId
	 * 
	 * @param Integer productId is the input parameter
	 * @return ProductDetailsResponseDto is the output parameter which includes
	 *         productId, productName, productDescription, productNav, rating,
	 *         brokerage, sixMonths, oneYear with status code
	 *
	 */
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<ProductDetailsResponseDto>> getProductDetails(@PathVariable Integer productId) {
		logger.info("in getProductDetials()");
		List<ProductDetailsResponseDto> response = productDetailsServiceImpl.getProductDetails(productId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
