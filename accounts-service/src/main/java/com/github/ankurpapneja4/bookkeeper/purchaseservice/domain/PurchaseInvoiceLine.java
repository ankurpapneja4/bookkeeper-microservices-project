package com.github.ankurpapneja4.bookkeeper.purchaseservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PurchaseInvoiceLine extends BaseEntityAudit {

    private Long productId;

    private BigDecimal qty;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn( name = "invoice_id")
    private PurchaseInvoice invoice;




}
