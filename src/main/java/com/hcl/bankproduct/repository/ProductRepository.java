package com.hcl.bankproduct.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.bankproduct.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
