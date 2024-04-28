package com.github.ankurpapneja4.bookkeeper.taxservice.services.inventoryservice;

import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("taxService_clientProductService")
public class ClientProductService {

    private final RestTemplate restTemplate;

    public ClientProductService(
            @Value("${productService.client.serviceUri}") String rootUri,
            RestTemplateBuilder builder ){

        this.restTemplate = builder.rootUri(rootUri).build();
    }

    public ProductDto findById( Long productId){
        return restTemplate.getForObject("/api/v1/products/"+productId, ProductDto.class);
    }
}
