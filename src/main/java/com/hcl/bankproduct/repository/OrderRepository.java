package com.hcl.bankproduct.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankproduct.entity.Orders;

/**
 * @author DeepikaSivarajan
 *
 */

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	public List<Orders> findByOrderDateGreaterThanAndOrderDateLessThan(LocalDate startDate, LocalDate endDate);

}
