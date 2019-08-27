/**
 * 
 */
package com.hcl.bankproduct;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankproduct.dto.ProductDetailsResponseDto;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.exception.ProductsNotFoundException;
import com.hcl.bankproduct.repository.ProductRepository;
import com.hcl.bankproduct.service.ProductDetailsServiceImpl;

/**
 * @author Gurpreet Singh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsServiceImplTest {

	@InjectMocks
	ProductDetailsServiceImpl productDetailsServiceImpl;
	
	@Mock
	ProductRepository productRepository;
	
	ProductDetailsResponseDto productDetailsResponseDto;
	Product product;
	List<Product> products;
	List<ProductDetailsResponseDto> productsresponse;
	
	public Product getProduct()
	{
		Product product = new Product();
		product.setBrokerage(12);
		product.setProductDescription("Bond");
		product.setProductId(1);
		product.setProductName("Mutual fund");
		product.setProductNav(123D);
		product.setRating(2);
		return product;
	}
	
	public ProductDetailsResponseDto getProductDetailsResponseDto()
	{
		ProductDetailsResponseDto productDetailsResponseDto = new ProductDetailsResponseDto();
		productDetailsResponseDto.setBrokerage(1);
		productDetailsResponseDto.setProductDescription("Bond");
		productDetailsResponseDto.setProductId(1);
		productDetailsResponseDto.setProductName("Mutual Fund");
		productDetailsResponseDto.setProductNav(12D);
		productDetailsResponseDto.setRating(3);
		return productDetailsResponseDto;
	}
	
	@Before
	public void setup()
	{
		productDetailsResponseDto = getProductDetailsResponseDto();
		product = getProduct();
		products = new ArrayList<>();
		productsresponse = new ArrayList<>();
		products.add(product);
		productsresponse.add(productDetailsResponseDto);
	}
	
	@Test
	public void testGetProductDetails()
	{
		Mockito.when(productRepository.findByProductId(Mockito.anyInt())).thenReturn(products);
		productsresponse = productDetailsServiceImpl.getProductDetails(1);
		assertEquals(productsresponse.get(0).getProductName(), productsresponse.get(0).getProductName());
	}
	
	@Test(expected = ProductsNotFoundException.class)
	public void testGetProductDetails_1()
	{
		productsresponse = productDetailsServiceImpl.getProductDetails(1);
	}
}
