package com.github.ankurpapneja4.bookkeeper.accountservice.repository;


import com.github.ankurpapneja4.bookkeeper.accountservice.domain.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}
