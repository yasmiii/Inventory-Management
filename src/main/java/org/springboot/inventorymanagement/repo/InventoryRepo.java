package org.springboot.inventorymanagement.repo;

import org.springboot.inventorymanagement.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
}
