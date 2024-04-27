package com.github.ankurpapneja4.bookkeeper.taxservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxRegister extends BaseEntityAudit {

    private Long invoiceId;

    private BigDecimal taxAmount;
}
