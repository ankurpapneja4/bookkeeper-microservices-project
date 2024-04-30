package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ankurpapneja4.bookkeeper.model.enums.JournalEntryType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalEntryDto{

    @Null
    private Long id;

    @Null
    private Long version;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat( pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private OffsetDateTime updatedDate;


    @NotNull
    private AccountDto creditAc;

    @NotNull
    private AccountDto debitAc;

    @NotNull
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    @NotNull
    @JsonFormat( pattern = "yyyy-MM-dd")
    private LocalDate transactionDate;

    @NotNull
    private JournalEntryType transactionType;

    private Long referenceId;
}
