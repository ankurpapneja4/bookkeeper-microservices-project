package com.github.ankurpapneja4.bookkeeper.inventoryservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Inventory extends BaseEntityAudit {

    @OneToOne
    @JoinColumn( name = "product_id")
    @Fetch( FetchMode.JOIN )
    private Product product;

    private BigDecimal totalPurchaseQty;

    private BigDecimal totalPurchaseAmt;

    private BigDecimal averagePrice;
}
