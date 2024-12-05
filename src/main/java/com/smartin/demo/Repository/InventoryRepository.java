package com.smartin.demo.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smartin.demo.Model.Inventory;
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	  List<Inventory> findByActive(boolean active);
	  List<Inventory> findByUserId(long userId);
}
