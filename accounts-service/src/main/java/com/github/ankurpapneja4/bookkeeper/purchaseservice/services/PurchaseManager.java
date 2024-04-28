package com.github.ankurpapneja4.bookkeeper.purchaseservice.services;

import com.github.ankurpapneja4.bookkeeper.model.enums.KafkaTopic;
import com.github.ankurpapneja4.bookkeeper.model.events.NewInvoiceAddedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("kafka")
@RequiredArgsConstructor
public class PurchaseManager {


    private final KafkaTemplate<String, NewInvoiceAddedEvent> kafkaTemplate;

    void onSave( NewInvoiceAddedEvent event ){
            kafkaTemplate.send( KafkaTopic.NewInvoice.name(), event );
    }

}
