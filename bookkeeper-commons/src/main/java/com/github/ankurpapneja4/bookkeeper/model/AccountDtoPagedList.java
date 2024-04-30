package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@JsonIgnoreProperties({ "pageable", "sort"})
public class AccountDtoPagedList extends PageImpl<AccountDto> {

    public AccountDtoPagedList(List<AccountDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public AccountDtoPagedList(List<AccountDto> content) {
        super(content);
    }
}
