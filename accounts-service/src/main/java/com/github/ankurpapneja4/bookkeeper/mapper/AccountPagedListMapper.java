package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Account;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.AccountDtoPagedList;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountPagedListMapper{

    private final AccountMapper accountMapper;

    public AccountDtoPagedList toAccountDtoPagedList(Page<Account> page){
        return new AccountDtoPagedList(
                        toListAccountDto( page.getContent() ),
                        PageRequest.of( page.getNumber(), page.getSize()),
                        page.getTotalElements()
                );
    }

    private List<AccountDto> toListAccountDto( List<Account> accountList){
        return accountList.stream().map(accountMapper::toAccountDto).collect(Collectors.toList());
    }

    public AccountDto toAccountDto(Account account) {
        return accountMapper.toAccountDto(account);
    }

    public Account toAccount(AccountDto accountDto) {
        return accountMapper.toAccount(accountDto);
    }
}
