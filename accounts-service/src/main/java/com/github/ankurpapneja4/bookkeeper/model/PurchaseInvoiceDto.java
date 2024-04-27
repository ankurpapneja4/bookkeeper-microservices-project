package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class PurchaseInvoiceDto {

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

    @NotBlank
    private String sellerInvoiceId;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotBlank
    private LocalDate invoiceDate;

    @NotNull
    private Long accountId;

    @Null
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private BigDecimal billAmount;

    @NotEmpty
    List<PurchaseInvoiceLineDto> purchaseInvoiceLInes;



}
