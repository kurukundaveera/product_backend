package com.hcl.bankproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankproduct.entity.Customer;

/**
 * @author DeepikaSivarajan
 *
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
