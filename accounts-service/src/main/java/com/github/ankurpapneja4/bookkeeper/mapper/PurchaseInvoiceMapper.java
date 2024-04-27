package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoice;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper( uses = { DateMapper.class, PurchaseInvoiceLineMapper.class}, componentModel = "spring")
public interface PurchaseInvoiceMapper {

    PurchaseInvoice toPurchaseInvoice(PurchaseInvoiceDto purchaseInvoiceDto);

    PurchaseInvoiceDto toPurchaseInvoiceDto( PurchaseInvoice purchaseInvoice);
}
