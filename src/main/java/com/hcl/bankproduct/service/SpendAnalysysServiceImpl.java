package com.hcl.bankproduct.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;

@Service
public class SpendAnalysysServiceImpl implements SpendAnalsysServcice {

	@Override
	public SpendAnalysysResponseDto getCurrentWeekAnalysys(String currentWeek) {
		if (currentWeek.equalsIgnoreCase("week")) {
			LocalDate currentDate = LocalDate.now();
			LocalDate weekDate = currentDate.minusDays(7);
			System.out.println(weekDate);
		}
		return null;
	}

//	public static void main(String a[])
//
//	{
//		LocalDate currentDate = LocalDate.now();
//		LocalDate weekDate = currentDate.minusDays(7);
//		System.out.println(weekDate);
//	}

}
