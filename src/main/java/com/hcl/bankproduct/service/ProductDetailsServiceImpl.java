/**
 * 
 */
package com.hcl.bankproduct.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.ProductDetailsResponseDto;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.exception.ProductsNotFoundException;
import com.hcl.bankproduct.repository.ProductRepository;
import com.hcl.bankproduct.util.ErrorConstants;


/**
 * @author Gurpreet Singh
 *
 */
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;

	/**
	 * This method is use to provide the product details by productId
	 * 
	 * @param Integer productId is the input
	 * @return ProductDetailsResponseDto is the output which includes productId,
	 *         productName, productDescription, productNav, rating, brokerage,
	 *         sixMonths, oneYear
	 */
	@Override
	public List<ProductDetailsResponseDto> getProductDetails(Integer productId) {
		logger.info("in getProductDetails() in serviceImpl");
		List<ProductDetailsResponseDto> response = new ArrayList<>();
		List<Product> products = productRepository.findByProductId(productId);
		if(products.isEmpty())
			throw new ProductsNotFoundException(ErrorConstants.ERROR_PRODUCT_NOT_FOUND);
		products.stream().forEach(p->
		{
			ProductDetailsResponseDto productDetails = new ProductDetailsResponseDto();
			BeanUtils.copyProperties(p, productDetails);
			response.add(productDetails);
		});
		return response;
	}

}
