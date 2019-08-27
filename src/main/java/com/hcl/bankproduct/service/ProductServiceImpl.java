package com.hcl.bankproduct.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.bankproduct.dto.ProductResponseDto;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.exception.ProductNotFoundException;
import com.hcl.bankproduct.repository.ProductRepository;
import com.hcl.bankproduct.util.ErrorConstants;
@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<ProductResponseDto> getAllProducts() {
		logger.info("inside the getAllProducts method");
		List<ProductResponseDto> responseList = new ArrayList<>();
		List<Product> productList = productRepository.findAll();
		if (productList.isEmpty())
			throw new ProductNotFoundException(ErrorConstants.ERROR_PRODUCTS_NOT_FOUND);
		    productList.stream().forEach(c -> {
			ProductResponseDto response = new ProductResponseDto();
			BeanUtils.copyProperties(c, response);
			responseList.add(response);
		});
		return responseList;
	}
}
