package com.github.ankurpapneja4.bookkeeper.accountservice.domain;


import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class JournalEntry extends BaseEntityAudit {

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn
    private Account creditAc;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn
    private Account debitAc;

    private BigDecimal amount;

    private String description;

    @Enumerated( EnumType.STRING )
    JournalEntryType type;

}
