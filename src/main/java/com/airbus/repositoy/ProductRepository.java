package com.airbus.repositoy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airbus.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.productCategory= ?1")
	ArrayList<Product> findByCategory(String category);
	@Query("select p.id from Product p where p.productId= ?1")
	List<Integer> getByProductId(String productId);

}
