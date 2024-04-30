package com.github.ankurpapneja4.bookkeeper.accountservice.web.mapper;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Account;
import com.github.ankurpapneja4.bookkeeper.accountservice.domain.JournalEntry;
import com.github.ankurpapneja4.bookkeeper.mapper.DateMapper;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.JournalEntryDto;
import org.mapstruct.Mapper;

@Mapper( uses = { DateMapper.class} , componentModel = "spring")
public interface JournalEntryMapper {

    JournalEntryDto toJournalEntryDto(JournalEntry journalEntry);

    JournalEntry toJournalEntry( JournalEntryDto journalEntryDto);

    AccountDto toAccountDto(Account account);

    Account toAccount( AccountDto accountDto);
}
