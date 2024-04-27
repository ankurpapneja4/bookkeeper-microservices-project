package com.github.ankurpapneja4.bookkeeper.purchaseservice.repository;

import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice,Long> {
}
