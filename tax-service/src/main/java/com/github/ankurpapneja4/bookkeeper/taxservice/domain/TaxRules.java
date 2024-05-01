package com.github.ankurpapneja4.bookkeeper.taxservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class TaxRules extends BaseEntity {

    private String hsnCode;
    private String hsnDescription;
    private Integer taxPercent;

}
