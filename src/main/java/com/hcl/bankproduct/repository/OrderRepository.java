package com.hcl.bankproduct.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.bankproduct.dto.SpendAnalysysResponseDto;
import com.hcl.bankproduct.entity.Orders;

/**
 * @author DeepikaSivarajan
 *
 */

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	
	@Query("select New com.hcl.bankproduct.dto.SpendAnalysysResponseDto (o.productId,p.productName, count(o.productId) as count) from Orders o,Product p" + 
			" where " + 
			" o.orderDate=:currentDate" + 
			" and " + 
			" o.productId=p.productId group by o.productId")
	List<SpendAnalysysResponseDto> getDailyAnalysys(@Param("currentDate") LocalDate currentDate);
	
	
	@Query("select New com.hcl.bankproduct.dto.SpendAnalysysResponseDto (o.productId,p.productName, count(o.productId) as count) from Orders o,Product p" + 
			" where " + 
			" o.orderDate " +
			"BETWEEN :startDate AND :endDate"+
			" and " + 
			" o.productId=p.productId group by o.productId")
	List<SpendAnalysysResponseDto> getAnalysys(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
	
	
//	List<SpendAnalysysResponseDto> findByOrderDateGreaterThanAndOrderDateLessThan(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);

}
