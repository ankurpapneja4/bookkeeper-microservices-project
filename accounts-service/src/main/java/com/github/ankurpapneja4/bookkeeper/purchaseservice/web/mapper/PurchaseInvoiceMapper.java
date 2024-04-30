package com.github.ankurpapneja4.bookkeeper.purchaseservice.web.mapper;

import com.github.ankurpapneja4.bookkeeper.mapper.DateMapper;
import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceLineDto;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoice;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.domain.PurchaseInvoiceLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper( uses = { DateMapper.class}, componentModel = "spring")
public interface PurchaseInvoiceMapper {

    @Mapping( target = "accountId", source="sellerAccountId")
    PurchaseInvoice toPurchaseInvoice(PurchaseInvoiceDto purchaseInvoiceDto );

    @Mapping( target="sellerAccountId", source = "accountId")
    PurchaseInvoiceDto toPurchaseInvoiceDto( PurchaseInvoice purchaseInvoice );

    @Mapping( target = "invoice", ignore = true)
    PurchaseInvoiceLine toPurchaseInvoiceLine(PurchaseInvoiceLineDto purchaseInvoiceLineDto);

    @Mapping( target = "invoiceId", source = "invoice.id")
    PurchaseInvoiceLineDto toPurchaseInvoiceLineDto(PurchaseInvoiceLine purchaseInvoiceLine);

    @Mapping( target = "invoice.id", source = "invoiceId")
    List<PurchaseInvoiceLine> toListPurchaseInvoiceLineDto( List<PurchaseInvoiceLineDto> listDto);

    List<PurchaseInvoiceLineDto> toListPurchaseInvoiceLine( List<PurchaseInvoiceLine> listPurchaseInvoiceLine );
}
