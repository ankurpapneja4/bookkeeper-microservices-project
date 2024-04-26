package com.github.ankurpapneja4.bookkeeper.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity{

    @CreationTimestamp
    @Column( updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;
}
