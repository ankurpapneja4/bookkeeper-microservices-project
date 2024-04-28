package com.github.ankurpapneja4.bookkeeper.inventoryservice.services.listeners;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.services.InventoryService;
import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.model.events.NewInvoiceAddedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NewInvoiceAddedEventListener {

    private final InventoryService inventoryService;

    @KafkaListener(
            id = "updateInventory",
            topics = "NewInvoice",
            groupId = "InventoryService",
            autoStartup = "true"
    )
    // KafkaTopic.NewInvoice
    @Transactional
    public void updateInventory(NewInvoiceAddedEvent event) {

        PurchaseInvoiceDto purchaseInvoice = event.getPurchaseInvoiceDto();

        purchaseInvoice.getPurchaseInvoiceLines().forEach(
                line -> inventoryService.addInventory( line.getProductId(), line.getQty(), line.getAmount() ));

    }
}
