package com.github.ankurpapneja4.bookkeeper.taxservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "tax_register")
public class TaxEntry extends BaseEntityAudit {

    private Long invoiceId;

    private BigDecimal taxAmount;
}
