package com.github.ankurpapneja4.bookkeeper.model.events;

import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewInvoiceAddedEvent {
    PurchaseInvoiceDto purchaseInvoiceDto;
}
