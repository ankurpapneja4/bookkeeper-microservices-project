package com.github.ankurpapneja4.bookkeeper.accountservice.domain;


import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @ManyToOne
    @JoinColumn( name = "cr_ac_id")
    @Fetch( FetchMode.JOIN )
    private Account creditAc;

    @ManyToOne
    @JoinColumn( name = "dr_ac_id" )
    @Fetch( FetchMode.JOIN )
    private Account debitAc;

    private BigDecimal amount;

    private LocalDate transactionDate;

    @Enumerated( EnumType.STRING )
    private JournalEntryType transactionType;

    // Reference To InvoiceId Or Tax Voucher
    private Long referenceId;

}
