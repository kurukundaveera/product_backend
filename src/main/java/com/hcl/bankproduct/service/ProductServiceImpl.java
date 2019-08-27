package com.hcl.bankproduct.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.bankproduct.dto.ExcelResponse;
import com.hcl.bankproduct.util.ExcelImportToDB;

@Service
public class ProductServiceImpl implements ProductService{
	
	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ExcelImportToDB excelImport;

	@Override
	public ExcelResponse importDataIntoDB(MultipartFile file) {
		logger.info("inside service");
		return excelImport.loadDataToDB(file);
	}

}
