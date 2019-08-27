/**
 * 
 */
package com.hcl.bankproduct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.ProductDetailsResponseDto;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public interface ProductDetailsService {
	
	public List<ProductDetailsResponseDto> getProductDetails(Integer productId);

}
