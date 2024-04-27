package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class InventoryDto {

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

    private Long productId;

    private String productName;

    private String productHsnCode;

    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private BigDecimal totalPurchaseQty;

    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private BigDecimal totalPurchaseAmt;

    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private BigDecimal averagePrice;

}
