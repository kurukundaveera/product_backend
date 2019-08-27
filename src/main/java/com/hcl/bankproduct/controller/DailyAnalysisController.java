/**
 * 
 */
package com.hcl.bankproduct.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankproduct.dto.DailyAnalysisRequestDto;
import com.hcl.bankproduct.dto.DailyAnalysisResponseDto;
import com.hcl.bankproduct.service.DailyAnalysisServiceImpl;

/**
 * @author Gurpreet Singh
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class DailyAnalysisController {

	private static final Logger logger = LoggerFactory.getLogger(DailyAnalysisController.class);
	
	@Autowired
	DailyAnalysisServiceImpl dailyAnalysisServiceImpl;

	/**
	 * This method is use to provide the product details on daily basis
	 * 
	 * @param Integer productId is the input parameter
	 * @return ProductDetailsResponseDto is the output parameter which includes
	 *         productId, productName, productDescription, productNav, rating,
	 *         brokerage, sixMonths, oneYear with status code
	 *
	 */
	@GetMapping("/order/day")
	public ResponseEntity<List<DailyAnalysisResponseDto>> getDailyAnalysisByDay(@RequestBody DailyAnalysisRequestDto daily) {
		logger.info("in getDailyAnalysisByDay()");
		List<DailyAnalysisResponseDto> response = dailyAnalysisServiceImpl.getDailyAnalysisByDay(daily);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
