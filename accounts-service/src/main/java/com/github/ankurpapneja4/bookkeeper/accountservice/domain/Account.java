package com.github.ankurpapneja4.bookkeeper.accountservice.domain;

import com.github.ankurpapneja4.bookkeeper.entities.BaseEntityAudit;
import com.github.ankurpapneja4.bookkeeper.model.enums.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
public class Account extends BaseEntityAudit {

    private String name;

    @Enumerated(EnumType.STRING)
    private Schedule schedule;


}
