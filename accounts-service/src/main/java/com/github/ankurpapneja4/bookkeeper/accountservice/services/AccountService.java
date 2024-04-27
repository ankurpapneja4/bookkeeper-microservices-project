package com.github.ankurpapneja4.bookkeeper.accountservice.services;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Account;
import com.github.ankurpapneja4.bookkeeper.accountservice.repository.AccountRepository;
import com.github.ankurpapneja4.bookkeeper.exceptions.NotFoundException;
import com.github.ankurpapneja4.bookkeeper.mapper.AccountMapper;
import com.github.ankurpapneja4.bookkeeper.mapper.AccountPagedListMapper;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.AccountDtoPagedList;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountPagedListMapper accountMapper;

    @Transactional( readOnly = true )
    public AccountDto findById( Long id){

        Assert.notNull(id, "Id not found");

        return
            accountMapper.toAccountDto(
                accountRepository.findById( id )
                        .orElseThrow( NotFoundException::new ) );
    }

    @Transactional( readOnly = true )
    public AccountDtoPagedList findAll(Pageable pageable){
        return accountMapper.toAccountDtoPagedList( accountRepository.findAll(pageable) );
    }

    @Transactional
    public Long createAccount(AccountDto accountDto){
        Account savedAccount =
            accountRepository.save( accountMapper.toAccount( accountDto ) );
        return savedAccount.getId();
    }
}
