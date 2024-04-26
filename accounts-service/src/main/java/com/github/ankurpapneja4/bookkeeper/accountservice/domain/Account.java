package com.github.ankurpapneja4.bookkeeper.accountservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account extends BaseEntityAudit {

    private String name;

    @Enumerated(EnumType.STRING)
    private Schedule schedule;


}
