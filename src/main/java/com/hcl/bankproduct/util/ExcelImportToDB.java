package com.hcl.bankproduct.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
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
		XSSFWorkbook workbook=null;
		try {

//			input = new FileInputStream("C:\\Priya\\Products.xlsx");
//			workbook = (XSSFWorkbook) WorkbookFactory.create((input));
			workbook =new XSSFWorkbook(file.getInputStream());

			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			List<Product> transactionList=new ArrayList<>();
			Row row;
			int result = 0;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				if (result == 0) {
					result = 1;
				} else {
				
					int productId = (int) row.getCell(0).getNumericCellValue();
					String productNm = row.getCell(1).getStringCellValue();
					String productDes = row.getCell(2).getStringCellValue();
					double productNav = row.getCell(3).getNumericCellValue();
					int rating =  (int)row.getCell(4).getNumericCellValue();
					int brokerage = (int)row.getCell(5).getNumericCellValue();
					
					
					logger.info(brokerage);					
					
					Product product=new Product();
					product.setProductId(productId);
					product.setProductName(productNm);
					product.setProductDescription(productDes);					
					product.setProductNav(productNav);
					product.setRating(rating);
					product.setBrokerage(brokerage);
					
					
					transactionList.add(product);
					
				}

			}
			productRepository.saveAll(transactionList);
			response.setMessage("success");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
		} finally {
			try {
				
				if(workbook!=null) {
					workbook.close();
				}
				if(input!=null) {
					input.close();
				}				
				sheet = null;
			} catch (Exception e) {
				logger.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
			}

		}
		return response;
	}

}
