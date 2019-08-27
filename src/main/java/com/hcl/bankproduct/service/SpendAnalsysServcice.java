package com.hcl.bankproduct.service;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;

public interface SpendAnalsysServcice {

	SpendAnalysysResponseDto getCurrentWeekAnalysys(String currentWeek);
}
