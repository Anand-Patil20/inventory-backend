package com.airbus.inventory.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airbus.inventory.domain.Inventory;
import com.airbus.inventory.repositoy.InventoryRepository;
import com.airbus.inventory.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Override
	public List<Inventory> getAllProducts() {
		List<Inventory> productList=inventoryRepository.findAll();
		return productList;
	}
	
	public List<Inventory> getByCategory(String category){
		List<Inventory> productList=inventoryRepository.findByCategory(category);
		return productList;
	}

	@Override
	public Inventory addProduct(Inventory product) {
		Inventory result=inventoryRepository.save(product);
		return result;
	}

	@Override
	public Inventory updateProduct(Inventory product) {
		Inventory result=inventoryRepository.save(product);
		return result;
	}

	@Override
	public String deleteProduct(String productId) {
		// add custom exception
		List<Integer> ids=inventoryRepository.getByProductId(productId);
		inventoryRepository.deleteAllById(ids);
		List<Integer> idAfterDelete=inventoryRepository.getByProductId(productId);
		if(idAfterDelete.isEmpty()) {
			return "Successfully Deleted";
		}
		return "Error in Deletion";
	}

}
