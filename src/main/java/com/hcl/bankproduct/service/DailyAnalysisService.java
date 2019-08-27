/**
 * 
 */
package com.hcl.bankproduct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.DailyAnalysisRequestDto;
import com.hcl.bankproduct.dto.DailyAnalysisResponseDto;

/**
 * @author user1
 *
 */
@Service
public interface DailyAnalysisService {
	
	public List<DailyAnalysisResponseDto> getDailyAnalysisByDay(DailyAnalysisRequestDto daily);

}
