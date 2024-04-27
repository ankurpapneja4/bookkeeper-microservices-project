package com.github.ankurpapneja4.bookkeeper.taxservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntity;
import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxRules extends BaseEntity {

    private String hsnCode;
    private String hsnDescription;
    private Integer taxPercent;

}
