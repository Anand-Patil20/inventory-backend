package com.airbus.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.domain.Product;
import com.airbus.repositoy.ProductRepository;
import com.airbus.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository ProductRepository;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> productList=ProductRepository.findAll();
		return productList;
	}
	
	public List<Product> getByCategory(String category){
		List<Product> productList=ProductRepository.findByCategory(category);
		return productList;
	}

	@Override
	public Product addProduct(Product product) {
		Product result=ProductRepository.save(product);
		return result;
	}


	@Override
	public String deleteProduct(String productId) {
		// add custom exception
		List<Integer> ids=ProductRepository.getByProductId(productId);
		ProductRepository.deleteAllById(ids);
		List<Integer> idAfterDelete=ProductRepository.getByProductId(productId);
		if(idAfterDelete.isEmpty()) {
			return "Successfully Deleted";
		}
		return "Error in Deletion";
	}

}
