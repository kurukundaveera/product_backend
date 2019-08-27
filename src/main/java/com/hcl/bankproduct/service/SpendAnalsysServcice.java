package com.hcl.bankproduct.service;

import java.util.List;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;

public interface SpendAnalsysServcice {

	List<SpendAnalysysResponseDto> getAnalysys(String currentWeek);
}
