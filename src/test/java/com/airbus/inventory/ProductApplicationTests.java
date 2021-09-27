package com.airbus.inventory;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import com.airbus.domain.Product;
import com.airbus.rest.ProductController;
import com.airbus.service.ProductService;

@SpringBootTest
class ProductApplicationTests {
	@InjectMocks
	ProductController controller;
	
	@Mock
	ProductService service;
	

//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
	
	@Test
	void getAllPositive() {
		List<Product> product=new ArrayList<>();
		product.add(new Product(1,"P01","Commercial","A320","Passenger aircraft family", 4));
		product.add(new Product(2,"P02","Commercial","A322","Passenger aircraft family", 4));
		when(service.getAllProducts()).thenReturn(product);
		List<Product> result = controller.getAll();
	    assertEquals(2, result.size());
	}
	@Test
	void getAllNegative() {
		List<Product> product=new ArrayList<>();
		product.add(new Product(1,"P01","Commercial","A320","Passenger aircraft family", 4));
		product.add(new Product(2,"P02","Commercial","A322","Passenger aircraft family", 4));
		when(service.getAllProducts()).thenReturn(product);
		List<Product> result = controller.getAll();
	    assertNotEquals(3, result.size());
	}
	
	
	@Test
    public void addProductTest()
    {
        Product prod = new Product(1,"P10","Commercial","A320","Passenger aircraft family", 4);
        controller.addProduct(prod);
        verify(service, times(1)).addProduct(prod);
    }
	@Test
    public void deleteProductTest()
    {
        Product prod = new Product(1,"P01","Commercial","A320","Passenger aircraft family", 4);
        controller.deleteProduct(prod.getProductId());
        verify(service, times(1)).deleteProduct(prod.getProductId());
    }
	
	@Test
    public void updateProductTest()
    {
        Product prod = new Product(1,"P10","Commercial","A320","Passenger aircraft family", 4);
        controller.updateProduct(prod);
        verify(service, times(1)).updateProduct(prod);
    }
}
