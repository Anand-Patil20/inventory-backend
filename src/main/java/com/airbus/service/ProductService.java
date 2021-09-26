package com.airbus.service;

import java.util.List;

import com.airbus.domain.Product;


public interface ProductService {

	List<Product> getAllProducts();

	List<Product> getByCategory(String category);

	Product addProduct(Product product);


	String deleteProduct(String productId);
}
