package com.github.ankurpapneja4.bookkeeper.inventoryservice.services.accountservice;

import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ClientAccountService {

    private final RestTemplate restTemplate;

    public ClientAccountService(
            @Value("${accountService.client.serviceUri}") String rootUri,
            RestTemplateBuilder restTemplateBuilder ){

        this.restTemplate = restTemplateBuilder.rootUri( rootUri ).build();
    }

    public AccountDto createAccount( AccountDto accountDto ){

         URI location = restTemplate.postForLocation( "/api/v1/accounts", accountDto);

         return restTemplate.getForObject( location, AccountDto.class);
    }


}
