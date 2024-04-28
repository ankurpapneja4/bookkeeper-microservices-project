package com.github.ankurpapneja4.bookkeeper.accountservice.services.listeners;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.JournalEntryType;
import com.github.ankurpapneja4.bookkeeper.accountservice.services.JournalEntryService;
import com.github.ankurpapneja4.bookkeeper.accountservice.services.productservice.ClientProductService;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.JournalEntryDto;
import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.model.events.NewInvoiceAddedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("accountService_newInvoiceAddedEventListener")
@RequiredArgsConstructor
public class NewInvoiceAddedEventListener {

    private final ClientProductService productService;

    private final JournalEntryService journalService;

    @KafkaListener(
            id = "addJournalEntryForNewInvoice",
            topics = "NewInvoice",
            groupId = "AccountService",
            autoStartup = "true"
    )
    @Transactional
    public void addJournalEntry(NewInvoiceAddedEvent event){

        PurchaseInvoiceDto purchaseInvoice = event.getPurchaseInvoiceDto();

        purchaseInvoice.getPurchaseInvoiceLines().forEach( line -> {

            // Get Product - Purchase Account Id
            ProductDto productDto = productService.findById( line.getProductId() );

            // Save Journal Entry
            journalService.saveJournalEntry(
                        JournalEntryDto.builder()
                            .referenceId( purchaseInvoice.getId() )
                            .transactionDate( purchaseInvoice.getInvoiceDate() )
                            .transactionType( JournalEntryType.PURCHASE)
                            .amount( line.getAmount() )
                            .creditAc( AccountDto.builder().id( purchaseInvoice.getSellerAccountId() ).build())
                            .debitAc ( AccountDto.builder().id( productDto.getPurchaseAccountId()    ).build())
                        .build());
        });

    }


}
