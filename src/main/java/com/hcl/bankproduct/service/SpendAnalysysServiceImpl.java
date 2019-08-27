package com.hcl.bankproduct.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;
import com.hcl.bankproduct.repository.OrderRepository;

@Service
public class SpendAnalysysServiceImpl implements SpendAnalsysServcice {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<SpendAnalysysResponseDto> getAnalysys(String currentWeek) {
		List<SpendAnalysysResponseDto> analysysList = null;

		if (currentWeek.equalsIgnoreCase("daily")) {
			analysysList = orderRepository.getDailyAnalysys(LocalDate.now());
		}

		else if (currentWeek.equalsIgnoreCase("week")) {
			LocalDate currentDate = LocalDate.now();
			LocalDate weekDate = currentDate.minusDays(7);
			analysysList = orderRepository.getAnalysys(weekDate, currentDate);
		}
		else
		{
			LocalDate currentDate = LocalDate.now();
			LocalDate weekDate = currentDate.minusDays(30);
			analysysList = orderRepository.getAnalysys(weekDate, currentDate);
		}
		return analysysList;
	}

}
