package com.github.ankurpapneja4.bookkeeper.taxservice.repository;

import com.github.ankurpapneja4.bookkeeper.taxservice.domain.TaxRules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaxRulesRepository extends JpaRepository<TaxRules, Long> {

    Optional<TaxRules> findByHsnCode(String hsnCode);
}
