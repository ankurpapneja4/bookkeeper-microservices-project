package com.github.ankurpapneja4.bookkeeper.taxservice.services.listener;

import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.model.events.NewInvoiceAddedEvent;
import com.github.ankurpapneja4.bookkeeper.taxservice.domain.TaxEntry;
import com.github.ankurpapneja4.bookkeeper.taxservice.domain.TaxRules;
import com.github.ankurpapneja4.bookkeeper.taxservice.repository.TaxEntryRepository;
import com.github.ankurpapneja4.bookkeeper.taxservice.repository.TaxRulesRepository;
import com.github.ankurpapneja4.bookkeeper.taxservice.services.inventoryservice.ClientProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service( "taxService_newInvoiceAddedEventListener")
@RequiredArgsConstructor
public class NewInvoiceAddedEventListener {

    private final TaxEntryRepository taxEntryRepository;

    private final TaxRulesRepository taxRulesRepository;

    private final ClientProductService clientProductService;

    @KafkaListener(
            id="addTaxEntryForNewInvoice",
            topics = "NewInvoice",
            groupId = "TaxService",
            autoStartup = "true"
    )

    @Transactional
    public void addTaxEntry(NewInvoiceAddedEvent event){
        PurchaseInvoiceDto purchaseInvoice = event.getPurchaseInvoiceDto();

        purchaseInvoice.getPurchaseInvoiceLines().forEach( line -> {

            TaxRules taxRule = taxRulesRepository.findByHsnCode( getHsnCode( line.getProductId() )).get();

            taxEntryRepository.save(
                        TaxEntry.builder()
                          .invoiceId( purchaseInvoice.getId() )
                          .taxAmount( calculateTaxAmount( line.getAmount(), taxRule.getTaxPercent()) )
                        .build());

        });
    }

    private String getHsnCode( Long productId ){
        return clientProductService.findById( productId).getHsnCode();
    }


    private BigDecimal calculateTaxAmount( BigDecimal amount, Integer taxPercent ){
        return amount.multiply( new BigDecimal(taxPercent) ).divide( new BigDecimal(100) );
    }


}
