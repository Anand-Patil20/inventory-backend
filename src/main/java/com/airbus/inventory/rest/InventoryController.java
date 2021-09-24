package com.airbus.inventory.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.airbus.inventory.domain.Inventory;
import com.airbus.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/products")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/getAll")
	public List<Inventory> getAll(){
		List<Inventory> productList=inventoryService.getAllProducts();
		return productList ;
	}
	
	@GetMapping("/getByCategory/{category}")
	public List<Inventory> getByCategory(@PathVariable(name = "category") String category){
		List<Inventory> productList=inventoryService.getByCategory(category);
		return productList ;
	}
	
	@PostMapping("/addProduct")
	public Inventory addProduct(@RequestBody Inventory product){
		Inventory productResult=inventoryService.addProduct(product);
		return productResult;
	}
	
	@PutMapping("/updateProduct")
	public Inventory updateProduct(@RequestBody Inventory product){
		Inventory productResult=inventoryService.updateProduct(product);
		return productResult;
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable(name = "productId") String productId){
		String message=inventoryService.deleteProduct(productId);
		return message;
	}
}
