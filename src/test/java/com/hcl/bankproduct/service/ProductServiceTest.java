package com.hcl.bankproduct.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hcl.bankproduct.dto.ProductResponseDto;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.exception.ProductNotFoundException;
import com.hcl.bankproduct.repository.ProductRepository;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);
	@Mock ProductRepository productRepository;
	@InjectMocks 
	ProductServiceImpl productService;
	List<Product> productList;
	Product product;
	@Before
	public void setUp() {
		productList = new ArrayList<>();
		product = new Product();
		product.setProductId(1);
		product.setProductDescription("DSP Bond fund");
		product.setBrokerage(34);
		product.setProductName("DSP Bond fund");
		product.setProductNav(1244.9);
		product.setRating(5);
		productList.add(product);		
	}
	@Test
	public void getAllProductsTest() {
		logger.info("inside the getAllProductsTest method");
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<ProductResponseDto> response = productService.getAllProducts();	
		Assert.assertEquals(product.getProductName(), response.get(0).getProductName());
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void getAllProductsTest_1() {
		logger.info("inside the getAllProductsTest method");
		 productService.getAllProducts();	
	}
	
}
