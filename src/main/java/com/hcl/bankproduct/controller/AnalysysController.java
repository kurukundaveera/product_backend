package com.hcl.bankproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;
import com.hcl.bankproduct.service.SpendAnalsysServcice;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class AnalysysController {

	@Autowired
	SpendAnalsysServcice spendAnalysysService;

	@GetMapping("/analysys/{report}")
	public ResponseEntity<List<SpendAnalysysResponseDto>> getAnalysys(@PathVariable String report) {
		return new ResponseEntity<>(spendAnalysysService.getAnalysys(report), HttpStatus.OK);
	}

	
}
