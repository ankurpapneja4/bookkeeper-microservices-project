package com.github.ankurpapneja4.bookkeeper.inventoryservice.web.controller;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.services.ProductService;
import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/v1/products")
    public ResponseEntity<ProductDto> createProduct(
                    @Valid @RequestBody ProductDto productDto){

        return ResponseEntity.ok( productService.createProduct( productDto));
    }

}
