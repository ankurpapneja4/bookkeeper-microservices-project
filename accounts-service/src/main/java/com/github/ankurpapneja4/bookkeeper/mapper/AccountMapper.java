package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Account;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.AccountDtoPagedList;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper( componentModel = "spring", uses = { DateMapper.class} )
public interface AccountMapper {

    AccountDto toAccountDto(Account account);

    Account toAccount( AccountDto accountDto);

    List<AccountDto> toListAccountDto(List<Account> account);

    default AccountDtoPagedList toAccountDtoPagedList(Page<Account> page){
        return new AccountDtoPagedList(
                toListAccountDto( page.getContent() ),
                PageRequest.of( page.getNumber(), page.getSize()),
                page.getTotalElements()
        );
    }

}
