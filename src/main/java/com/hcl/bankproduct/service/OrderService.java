package com.hcl.bankproduct.service;

import com.hcl.bankproduct.dto.OrderRequestDto;
import com.hcl.bankproduct.dto.OrderResponseDto;

public interface OrderService {

	OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

}
