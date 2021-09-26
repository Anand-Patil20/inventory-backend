package com.airbus.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.airbus.domain.Product;
import com.airbus.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService ProductService;
	
	@GetMapping("/getAll")
	public List<Product> getAll(){
		List<Product> productList=ProductService.getAllProducts();
		return productList ;
	}
	
	@GetMapping("/getByCategory/{category}")
	public List<Product> getByCategory(@PathVariable(name = "category") String category){
		List<Product> productList=ProductService.getByCategory(category);
		return productList ;
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product){
		Product productResult=ProductService.addProduct(product);
		return productResult;
	}

	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable(name = "productId") String productId){
		String message=ProductService.deleteProduct(productId);
		return message;
	}
}
