package com.github.ankurpapneja4.bookkeeper.inventoryservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product extends BaseEntityAudit {

    private String name;

    private String hsnCode;

    private Long saleAccountId;

    private Long purchaseAccountId;

}
