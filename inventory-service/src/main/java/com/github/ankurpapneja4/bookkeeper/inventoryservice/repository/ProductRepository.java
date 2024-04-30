package com.github.ankurpapneja4.bookkeeper.inventoryservice.repository;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
