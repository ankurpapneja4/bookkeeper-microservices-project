package com.github.ankurpapneja4.bookkeeper.accountservice.domain;


import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name= "journal_register")
public class JournalEntry extends BaseEntityAudit {

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "cr_ac_id")
    private Account creditAc;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "dr_ac_id" )
    private Account debitAc;

    private BigDecimal amount;

    private LocalDate transactionDate;

    @Enumerated( EnumType.STRING )
    private JournalEntryType transactionType;

    // Reference To InvoiceId Or Tax Voucher
    private Long referenceId;

}
