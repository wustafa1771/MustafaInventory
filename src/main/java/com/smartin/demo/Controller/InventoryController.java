package com.smartin.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartin.demo.Model.Inventory;
import com.smartin.demo.service.InventoryService;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InventoryController {

	  @Autowired
	  InventoryService inventoryService;
	  
	  
	  @GetMapping("/inventory")
	  public ResponseEntity<List<Inventory>> getAllinventory() {
		    try {
		      List<Inventory> inventory = new ArrayList<Inventory>();
		      inventory = inventoryService.getAllServices();
		
		      if (inventory.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(inventory, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	  

	  @GetMapping("/inventory/{id}")
	  public ResponseEntity<Inventory> getInventoryById(@RequestParam(value ="userId") long id) {
	    Optional<Inventory> invData = inventoryService.getInventoryById(id);

	    if (invData.isPresent()) {
	      return new ResponseEntity<>(invData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/inventory")
	  public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inv) {
	    try {
	    	Inventory inv1 = new Inventory(inv.getinventory_name(), inv.getDescription(),inv.isactive(),inv.getUserId());
	    	Inventory _inv = inventoryService.saveInventory(inv1);
	      return new ResponseEntity<>(_inv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


	  @DeleteMapping("/inventory/{id}")
	  public ResponseEntity<HttpStatus> deleteinv(@RequestParam(value ="userId") long id) {
	    try {
	    	inventoryService.deleteInventory(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  

	  @GetMapping("/inventory/published")
	  public ResponseEntity<List<Inventory>> findByPublished() {
	    try {
	      List<Inventory> inventory = inventoryService.findByAvailable();
	      
	      if (inventory.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(inventory, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/inventory/BUID")
	  public ResponseEntity<List<Inventory>> findByUserId(@RequestParam(value ="userId") long userId) {
	    try {
	      List<Inventory> inventory = inventoryService.findByUserId(userId);
	      
	      if (inventory.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(inventory, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
