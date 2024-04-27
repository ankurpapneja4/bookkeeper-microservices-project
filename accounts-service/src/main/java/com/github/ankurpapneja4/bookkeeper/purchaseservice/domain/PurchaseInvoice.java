package com.github.ankurpapneja4.bookkeeper.purchaseservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany( mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    @Fetch( FetchMode.JOIN )
    List<PurchaseInvoiceLine> purchaseInvoiceLines;

}
