package com.github.ankurpapneja4.bookkeeper.purchaseservice.services;

import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.model.events.NewInvoiceAddedEvent;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoice;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.repository.PurchaseInvoiceRepository;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.web.mapper.PurchaseInvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseInvoiceService {

    private final PurchaseInvoiceRepository purchaseInvoiceRepository;

    private final PurchaseManager purchaseManager;

    private final PurchaseInvoiceMapper invoiceMapper;

    @Transactional
    public PurchaseInvoiceDto save(PurchaseInvoiceDto purchaseInvoiceDto){

        PurchaseInvoice invoice = invoiceMapper.toPurchaseInvoice( purchaseInvoiceDto);

        // Set Bidirectional Mapping - Hibernate
        invoice.getPurchaseInvoiceLines().forEach( line -> line.setInvoice( invoice ));

        // Save Invoice
        PurchaseInvoiceDto savedInvoice = invoiceMapper.toPurchaseInvoiceDto( purchaseInvoiceRepository.save( invoice ) );

        // onSave
        purchaseManager.onSave( new NewInvoiceAddedEvent( savedInvoice) );

        return savedInvoice;
    }

}
