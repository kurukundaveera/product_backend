package com.hcl.bankproduct.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.bankproduct.dto.ExcelResponse;
import com.hcl.bankproduct.service.ProductService;

/**
 * 
 * @author HAriPriya G
 *
 */

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@PostMapping("/import")
	public ResponseEntity<ExcelResponse> importExcell(@RequestParam("file") MultipartFile reapExcelDataFile)
			throws IOException {
		logger.info("product controller");
		return new ResponseEntity<>(productService.importDataIntoDB(reapExcelDataFile), HttpStatus.OK);
	}
}
