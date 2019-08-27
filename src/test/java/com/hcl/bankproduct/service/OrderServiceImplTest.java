/**
 * 
 */
package com.hcl.bankproduct.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankproduct.dto.OrderRequestDto;
import com.hcl.bankproduct.dto.OrderResponseDto;
import com.hcl.bankproduct.entity.Customer;
import com.hcl.bankproduct.entity.Orders;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.exception.CustomerNotFoundException;
import com.hcl.bankproduct.exception.ProductNotFoundException;
import com.hcl.bankproduct.repository.CustomerRepository;
import com.hcl.bankproduct.repository.OrderRepository;
import com.hcl.bankproduct.repository.ProductRepository;

/**
 * @author Gurpreet Singh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
	
	@InjectMocks
	OrderServiceImpl orderServiceImpl;
	
	@Mock
	OrderRepository orderRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	CustomerRepository customerRepository;
	
	OrderResponseDto orderResponseDto;
	OrderRequestDto orderRequestDto;
	Customer customer;
	Product product;
	Orders orders;
	
	public OrderResponseDto getOrderResponseDto()
	{
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		orderResponseDto.setMessage("Order Placed Successfully");
		orderResponseDto.setOrderId(1);
		return orderResponseDto;
	}
	
	public OrderRequestDto getOrderRequestDto()
	{
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setCity("bangalore");
		orderRequestDto.setCustomerName("Gurpreet");
		orderRequestDto.setEmailId("gurpreet.gohir@gmail.com");
		orderRequestDto.setMobileNumber("9898776655");
		orderRequestDto.setProductId(1);
		orderRequestDto.setQuantity(1);
		return orderRequestDto;
	}
	
	public Customer getCustomer()
	{
		Customer customer = new Customer();
		customer.setCity("bangalore");
		customer.setCustomerId(1);
		customer.setCustomerName("Gurpreet");
		customer.setEmailId("gurpreet.gohir@gmail.com");
		customer.setMobileNumber("9988776655");
		return customer;
	}
	
	public Product getProduct()
	{
		Product product = new Product();
		product.setBrokerage(12);
		product.setProductDescription("Bond");
		product.setProductId(1);
		product.setProductName("Fund");
		product.setProductNav(12D);
		product.setRating(2);
		return product;
	}
	
	public Orders getOrders()
	{
		Orders orders = new Orders();
		orders.setCustomerId(1);
		orders.setOrderDate(LocalDate.of(2019, 8, 27));
		orders.setOrderId(1);
		orders.setProductId(1);
		orders.setQuantity(12);
		orders.setStatus("purchased");
		orders.setTotalPrice(123D);
		return orders;
	}
	
	@Before
	public void setup()
	{
		orderResponseDto = getOrderResponseDto();
		orderRequestDto = getOrderRequestDto();
		product = getProduct();
		orders = getOrders();
		customer = getCustomer();
	}
	
	@Test
	public void testCreateOrder()
	{
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(product));
		Mockito.when(orderRepository.save(Mockito.any())).thenReturn(orders);
		OrderResponseDto response = orderServiceImpl.createOrder(orderRequestDto);
		assertEquals("Order Placed Successfully", response.getMessage());
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void testCreateOrder_1()
	{
		orderServiceImpl.createOrder(orderRequestDto);
	}
	

	@Test(expected = CustomerNotFoundException.class)
	public void testCreateOrder_3()
	{
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(product));
		customer.setCustomerId(null);
		orderServiceImpl.createOrder(orderRequestDto);
	}
	
}
