package com.github.ankurpapneja4.bookkeeper.inventoryservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory extends BaseEntityAudit {

    @OneToOne
    @JoinColumn( name = "product_id")
    private Product product;

    private BigDecimal totalPurchaseQty;

    private BigDecimal totalPurchaseAmt;

    private BigDecimal averagePrice;
}
