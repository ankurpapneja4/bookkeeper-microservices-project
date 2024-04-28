package com.github.ankurpapneja4.bookkeeper.accountservice.services;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.JournalEntry;
import com.github.ankurpapneja4.bookkeeper.accountservice.repository.AccountRepository;
import com.github.ankurpapneja4.bookkeeper.accountservice.repository.JournalEntryRepository;
import com.github.ankurpapneja4.bookkeeper.mapper.JournalEntryMapper;
import com.github.ankurpapneja4.bookkeeper.model.JournalEntryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JournalEntryService {

    private final JournalEntryRepository journalRepository;

    private final AccountRepository accountRepository;

    private final JournalEntryMapper journalMapper;

    @Transactional
    public void saveJournalEntry(JournalEntryDto journalEntryDto){
        JournalEntry journalEntry = journalMapper.toJournalEntry( journalEntryDto );

        journalEntry.setCreditAc( accountRepository.findById( journalEntry.getCreditAc().getId() ).get());
        journalEntry.setDebitAc ( accountRepository.findById( journalEntry.getDebitAc().getId()  ).get());

        journalRepository.save( journalEntry );
    }
}
