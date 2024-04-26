package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Account;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import org.mapstruct.Mapper;

@Mapper( uses = DateMapper.class)
public interface AccountMapper {

    AccountDto toAccountDto(Account account);

    Account toAccount( AccountDto accountDto);

}
