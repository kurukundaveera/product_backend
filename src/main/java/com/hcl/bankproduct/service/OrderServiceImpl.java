package com.hcl.bankproduct.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankproduct.dto.OrderRequestDto;
import com.hcl.bankproduct.dto.OrderResponseDto;
import com.hcl.bankproduct.entity.Customer;
import com.hcl.bankproduct.entity.Orders;
import com.hcl.bankproduct.entity.Product;
import com.hcl.bankproduct.exception.CustomerNotFoundException;
import com.hcl.bankproduct.exception.InformationNotFoundException;
import com.hcl.bankproduct.exception.InsufficientQuantityException;
import com.hcl.bankproduct.exception.OrderNotFoundException;
import com.hcl.bankproduct.exception.ProductNotFoundException;
import com.hcl.bankproduct.repository.CustomerRepository;
import com.hcl.bankproduct.repository.OrderRepository;
import com.hcl.bankproduct.repository.ProductRepository;
import com.hcl.bankproduct.util.ErrorConstants;

/**
 * @author DeepikaSivarajan
 *
 */

@Service
public class OrderServiceImpl implements OrderService {
	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerRepository customerRepository;

	/**
	 * This method is intended to buy a product
	 * 
	 * @param OrderRequestDto is the input request object which includes
	 *                        productId,customerName,mobileNumber,emailId,city,quantity
	 * @return OrderResponseDto which includes message
	 * @exception InformationNotFoundException,ProductNotFoundException,CustomerNotFoundException,InsufficientQuantityException
	 */
	@Override
	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
		logger.info("creating order in service {} : ", orderRequestDto.getProductId());
		OrderResponseDto response = new OrderResponseDto();
		if (orderRequestDto.getProductId() == null) {
			throw new InformationNotFoundException(ErrorConstants.DETAILS_NOT_FOUND);
		} else {
			Customer customer = Customer.builder().customerName(orderRequestDto.getCustomerName())
					.emailId(orderRequestDto.getEmailId()).mobileNumber(orderRequestDto.getMobileNumber())
					.city(orderRequestDto.getCity()).build();
			Customer customerResponse = customerRepository.save(customer);

			Optional<Product> product = productRepository.findById(orderRequestDto.getProductId());
			if (!product.isPresent())
				throw new ProductNotFoundException(ErrorConstants.PRODUCT_NOT_FOUND);
			if (customerResponse.getCustomerId() == null)
				throw new CustomerNotFoundException(ErrorConstants.CUSTOMER_NOT_FOUND);
			if (orderRequestDto.getQuantity() > 500)
				throw new InsufficientQuantityException(ErrorConstants.INSUFFICIENT_QUANTITY_EXCEPTION);

			Double brokeragePercent = product.get().getBrokerage() / 100d;
			Double brokerageAmount = orderRequestDto.getQuantity() * product.get().getProductNav() * brokeragePercent;
			Double totalPrice = orderRequestDto.getQuantity() * product.get().getProductNav() + brokerageAmount;

			Orders orders = Orders.builder().productId(product.get().getProductId())
					.quantity(orderRequestDto.getQuantity()).status("purchased").totalPrice(totalPrice)
					.customerId(customerResponse.getCustomerId()).build();
			Orders responseOrder = orderRepository.save(orders);
			if (responseOrder.getOrderId() == null)
				throw new OrderNotFoundException(ErrorConstants.ORDER_NOT_FOUND);
			response.setOrderId(responseOrder.getOrderId());
			response.setMessage("Order Placed Successfully");
			logger.info("order success for the id {} : ", responseOrder.getOrderId());
		}
		return response;
	}

}
