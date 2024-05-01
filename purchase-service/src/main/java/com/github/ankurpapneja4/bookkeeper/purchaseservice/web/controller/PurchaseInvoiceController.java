package com.github.ankurpapneja4.bookkeeper.purchaseservice.web.controller;

import com.github.ankurpapneja4.bookkeeper.model.PurchaseInvoiceDto;
import com.github.ankurpapneja4.bookkeeper.purchaseservice.services.PurchaseInvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PurchaseInvoiceController {

    private final PurchaseInvoiceService purchaseInvoiceService;

    @PostMapping("/api/v1/invoice")
    public ResponseEntity<PurchaseInvoiceDto> saveInvoice(
            @Valid @RequestBody PurchaseInvoiceDto purchaseInvoiceDto){

        return ResponseEntity.ok( purchaseInvoiceService.save(purchaseInvoiceDto) );
    }
}
