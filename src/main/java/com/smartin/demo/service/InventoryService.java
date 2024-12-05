package com.smartin.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartin.demo.Model.Inventory;
import com.smartin.demo.Model.User;
import com.smartin.demo.Repository.InventoryRepository;
import com.smartin.demo.Repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void init() {
		User user1 = new User();
		user1.setUserName("mustafa");
		user1.setUserRole("role");
		//userRepository.save(user1);
		User user2 = new User();
		user2.setUserName("deneme");
		user2.setUserRole("role2");
		//userRepository.save(user2);
		
	}

	public List<Inventory> getAllServices() {
		List<Inventory> inventories = inventoryRepository.findAll();
		return inventories;
	}

	public Optional<Inventory> getInventoryById(long id) {
		Optional<Inventory> inv = inventoryRepository.findById(id);
		return inv;
	}

	public Inventory saveInventory(Inventory inv) {
		Inventory createdInv = inventoryRepository.save(inv);

		return createdInv;
	}

	public void deleteInventory(long id) {
		inventoryRepository.deleteById(id);

	}

	public List<Inventory> findByAvailable() {
		// List<Inventory> inventories = inventoryRepository.findByPublished(true);
		return null;
	}

	public List<Inventory> findByUserId(long userId) {
		List<Inventory> inventories = inventoryRepository.findByUserId(userId);
		return inventories ;
	}

}
