package com.airbus.inventory.repositoy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airbus.inventory.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	@Query("select p from Inventory p where p.productCategory=?1")
	ArrayList<Inventory> findByCategory(String category);
	@Query("select p.id from Inventory p where p.productId=?1")
	List<Integer> getByProductId(String productId);

}
