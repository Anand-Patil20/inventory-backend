package com.airbus.inventory.service;

import java.util.List;
import com.airbus.inventory.domain.Inventory;


public interface InventoryService {

	List<Inventory> getAllProducts();

	List<Inventory> getByCategory(String category);

	Inventory addProduct(Inventory product);

	Inventory updateProduct(Inventory product);

	String deleteProduct(String productId);
}
