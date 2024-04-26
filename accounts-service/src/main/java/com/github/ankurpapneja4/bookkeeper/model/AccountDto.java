package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Schedule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto  extends BaseAuditDto{

    @NotBlank
    private String name;

    @NotBlank
    private Schedule schedule;

}
