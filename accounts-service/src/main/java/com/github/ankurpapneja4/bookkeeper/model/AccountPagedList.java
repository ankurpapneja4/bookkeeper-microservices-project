package com.github.ankurpapneja4.bookkeeper.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AccountPagedList extends PageImpl<AccountDto> {

    public AccountPagedList(List<AccountDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public AccountPagedList(List<AccountDto> content) {
        super(content);
    }
}
