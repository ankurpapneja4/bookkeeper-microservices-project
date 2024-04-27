package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceLineDto;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoiceLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( uses = { DateMapper.class}, componentModel = "spring")
public interface PurchaseInvoiceLineMapper {

    @Mapping( source = "invoice.id" , target = "invoiceId")
    PurchaseInvoiceLineDto toPurchaseInvoiceLineDto(PurchaseInvoiceLine purchaseInvoiceLine);

    @Mapping( source = "invoiceId", target = "invoice.Id")
    PurchaseInvoiceLine toPurchaseInvoiceLine(PurchaseInvoiceLineDto purchaseInvoiceLineDto);
}
