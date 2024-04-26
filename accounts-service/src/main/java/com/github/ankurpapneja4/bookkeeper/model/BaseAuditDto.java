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
public abstract class BaseAuditDto extends BaseDto {


    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat( pattern = "yyyy-MM5-dd'T'HH:mm:ssZ")
    private OffsetDateTime updatedDate;
}
