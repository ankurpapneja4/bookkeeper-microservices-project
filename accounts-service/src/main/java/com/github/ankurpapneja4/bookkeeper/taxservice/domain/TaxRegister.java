package com.github.ankurpapneja4.bookkeeper.taxservice.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxRegister {

    private Long invoiceId;

    private BigDecimal taxAmount;
}
