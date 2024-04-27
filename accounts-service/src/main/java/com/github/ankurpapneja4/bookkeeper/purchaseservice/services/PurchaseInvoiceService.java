package com.github.ankurpapneja4.bookkeeper.purchaseservice.services;

import com.github.ankurpapneja4.bookkeeper.mapper.PurchaseInvoiceMapper;
import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoice;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.repository.PurchaseInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseInvoiceService {

    private final PurchaseInvoiceRepository purchaseInvoiceRepository;

    private final PurchaseInvoiceMapper invoiceMapper;

    public PurchaseInvoiceDto save(PurchaseInvoiceDto purchaseInvoiceDto){

        PurchaseInvoice savedInvoice = purchaseInvoiceRepository.save(
                                            invoiceMapper.toPurchaseInvoice( purchaseInvoiceDto));

        return invoiceMapper.toPurchaseInvoiceDto( savedInvoice );
    }

}
