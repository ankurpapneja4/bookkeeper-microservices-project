package com.github.ankurpapneja4.bookkeeper.inventoryservice.repository;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    Optional<Inventory> findByProductId( Long productId );

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("select i from Inventory i where i.product.id = :productId")
    Optional<Inventory> findByProductIdWithLock( Long productId );
}
