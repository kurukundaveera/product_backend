package com.hcl.bankproduct.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.bankproduct.dto.ExcelResponse;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.repository.ProductRepository;

@Component
public class ExcelImportToDB {

	private static final Logger logger = LogManager.getLogger(ExcelImportToDB.class);

	@Autowired
	private ProductRepository productRepository;

	public ExcelResponse loadDataToDB(MultipartFile file) {

		ExcelResponse response = new ExcelResponse();
		FileInputStream input = null;
		XSSFSheet sheet = null;
		XSSFWorkbook workbook = null;
		
		try {
//			input = new FileInputStream("C:\\Priya\\Products.xlsx");
//			workbook = (XSSFWorkbook) WorkbookFactory.create((input));
			workbook = new XSSFWorkbook(file.getInputStream());
			sheet = workbook.getSheetAt(0);
			
			List<Product> transactionList = new ArrayList<>();
			List<Product> productslIst = productRepository.findAll();
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				if (!productslIst.isEmpty()) {
					if (!productslIst.get(i-1).getProductName().equalsIgnoreCase(row.getCell(1).getStringCellValue())) {
						Product product = setProduct(row);
						transactionList.add(product);
					}
				} else {
					Product product = setProduct(row);
					transactionList.add(product);
				}
			}
			productRepository.saveAll(transactionList);
			response.setMessage("success");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
		} finally {
			try {

				if (workbook != null) {
					workbook.close();
				}
				if (input != null) {
					input.close();
				}
				sheet = null;
			} catch (Exception e) {
				logger.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
			}

		}
		return response;
	}

	private Product setProduct(Row row) {
		Product product = new Product();
		product.setProductId((int) row.getCell(0).getNumericCellValue());
		product.setProductName(row.getCell(1).getStringCellValue());
		product.setProductDescription(row.getCell(2).getStringCellValue());
		product.setProductNav(row.getCell(3).getNumericCellValue());
		product.setRating((int) row.getCell(4).getNumericCellValue());
		product.setBrokerage((int) row.getCell(5).getNumericCellValue());
		return product;
	}

}
