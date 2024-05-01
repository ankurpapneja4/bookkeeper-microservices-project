package com.github.ankurpapneja4.bookkeeper.taxservice.repository;

import com.github.ankurpapneja4.bookkeeper.taxservice.domain.TaxEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxEntryRepository extends JpaRepository<TaxEntry,Long> {
}
