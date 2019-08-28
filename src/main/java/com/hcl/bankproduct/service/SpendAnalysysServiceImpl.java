package com.hcl.bankproduct.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

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
			final ZoneId zt = ZoneId.of("Pacific/Auckland");
			final DayOfWeek firstDayOfWeek = WeekFields.of(Locale.US).getFirstDayOfWeek();

			LocalDate firstDayInWeek = LocalDate.now(zt).with(TemporalAdjusters.previousOrSame(firstDayOfWeek));
			LocalDate currentDate = LocalDate.now();
			analysysList = orderRepository.getAnalysys(firstDayInWeek, currentDate);
		} else {

			LocalDate monthBegin = LocalDate.now().withDayOfMonth(1);
			LocalDate currentDate = LocalDate.now();
			analysysList = orderRepository.getAnalysys(monthBegin, currentDate);
		}
		return analysysList;
	}

}
