package com.github.ankurpapneja4.bookkeeper.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT", updatable = false, nullable = false)
    private Long id;

    @Version
    private Long version;
}
