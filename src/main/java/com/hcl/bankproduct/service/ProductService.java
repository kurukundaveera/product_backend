package com.hcl.bankproduct.service;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.bankproduct.dto.ExcelResponse;

public interface ProductService {
	
	public ExcelResponse importDataIntoDB(MultipartFile file);

}
