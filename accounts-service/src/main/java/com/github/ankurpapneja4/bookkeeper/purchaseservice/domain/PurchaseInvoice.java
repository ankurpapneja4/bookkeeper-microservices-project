package com.github.ankurpapneja4.bookkeeper.purchaseservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseInvoice extends BaseEntityAudit {

    private String sellerInvoiceId;

    private LocalDate invoiceDate;

    private Long accountId;

    private BigDecimal billAmount;

}
