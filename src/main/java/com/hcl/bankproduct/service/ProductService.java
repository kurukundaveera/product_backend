package com.hcl.bankproduct.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.bankproduct.dto.ExcelResponse;
import com.hcl.bankproduct.dto.ProductResponseDto;
@Service
public interface ProductService {
	
	public ExcelResponse importDataIntoDB(MultipartFile file);

	public List<ProductResponseDto> getAllProducts();
	
}
