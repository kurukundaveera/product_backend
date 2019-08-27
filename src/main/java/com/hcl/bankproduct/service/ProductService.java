package com.hcl.bankproduct.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.ProductResponseDto;
@Service
public interface ProductService {

	public List<ProductResponseDto> getAllProducts();
	
}
