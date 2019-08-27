/**
 * 
 */
package com.hcl.bankproduct.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;
import com.hcl.bankproduct.repository.OrderRepository;

/**
 * @author user1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SpendAnalysysServiceImplTest {
	
	@InjectMocks
	SpendAnalysysServiceImpl spendAnalysysServiceImpl;
	
	@Mock
	OrderRepository orderRepository;
	
	SpendAnalysysResponseDto spendAnalysysResponseDto;
	List<SpendAnalysysResponseDto> listSpendAnalysysResponseDto;
	
	public SpendAnalysysResponseDto getSpendAnalysysResponseDto()
	{
		SpendAnalysysResponseDto spendAnalysysResponseDto = new SpendAnalysysResponseDto();
		spendAnalysysResponseDto.setCount(1L);
		spendAnalysysResponseDto.setProductId(1);
		spendAnalysysResponseDto.setProductName("Fund");
		return spendAnalysysResponseDto;
	}
	
	@Before
	public void setup()
	{
		spendAnalysysResponseDto = getSpendAnalysysResponseDto();
		listSpendAnalysysResponseDto = new ArrayList<>();
		listSpendAnalysysResponseDto.add(spendAnalysysResponseDto);
		
	}
	
	@Test
	public void testGetAnalysys()
	{
		String currentWeek = "daily";
		Mockito.when(orderRepository.getDailyAnalysys(LocalDate.now())).thenReturn(listSpendAnalysysResponseDto);
		List<SpendAnalysysResponseDto> analysysList = spendAnalysysServiceImpl.getAnalysys(currentWeek);
		assertEquals(listSpendAnalysysResponseDto.get(0).getProductName(), analysysList.get(0).getProductName());
	}
	
	@Test
	public void testGetAnalysys_1()
	{
		String currentWeek = "week";
		LocalDate currentDate = LocalDate.now();
		LocalDate weekDate = currentDate.minusDays(7);
		Mockito.when(orderRepository.getAnalysys(weekDate, currentDate)).thenReturn(listSpendAnalysysResponseDto);
		List<SpendAnalysysResponseDto> analysysList = spendAnalysysServiceImpl.getAnalysys(currentWeek);
		assertEquals(listSpendAnalysysResponseDto.get(0).getProductName(), analysysList.get(0).getProductName());
	}
	@Test
	public void testGetAnalysys_2()
	{
		String currentWeek = "month";
		LocalDate currentDate = LocalDate.now();
		LocalDate weekDate1 = currentDate.minusDays(30);
		Mockito.when(orderRepository.getAnalysys(weekDate1, currentDate)).thenReturn(listSpendAnalysysResponseDto);
		List<SpendAnalysysResponseDto> analysysList = spendAnalysysServiceImpl.getAnalysys(currentWeek);
		assertEquals(listSpendAnalysysResponseDto.get(0).getProductName(), analysysList.get(0).getProductName());
	}
	

}
