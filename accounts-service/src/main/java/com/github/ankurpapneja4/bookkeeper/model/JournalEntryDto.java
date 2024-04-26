package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@Builder
public class JournalEntryDto extends BaseAuditDto{

}
