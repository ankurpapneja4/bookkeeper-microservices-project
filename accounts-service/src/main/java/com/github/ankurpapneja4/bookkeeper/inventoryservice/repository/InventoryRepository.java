package com.github.ankurpapneja4.bookkeeper.inventoryservice.repository;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
