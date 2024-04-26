package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseDto {

    @Null
    private Long id;

    @Null
    private Long version;

}
