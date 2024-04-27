package com.github.ankurpapneja4.bookkeeper.inventoryservice.services;

import com.github.ankurpapneja4.bookkeeper.accountservice.domain.Schedule;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Product;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.repository.ProductRepository;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.services.accountservice.AccountService;
import com.github.ankurpapneja4.bookkeeper.mapper.ProductMapper;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final AccountService accountService;
    private final ProductMapper productMapper;


    @Transactional
    public ProductDto createProduct( ProductDto productDto ){

        // Create Product's Purchase Account
        AccountDto purchaseAccount = accountService.createAccount(
                AccountDto.builder()
                        .name("Purchase - " + productDto.getName())
                        .schedule( Schedule.PURCHASE )
                        .build());

        // Create Product's Sales Account
        AccountDto saleAccount = accountService.createAccount(
                AccountDto.builder()
                        .name("Sale - " + productDto.getName())
                        .schedule( Schedule.SALES )
                        .build());

        productDto.setPurchaseAccountId( purchaseAccount.getId() );
        productDto.setSaleAccountId( saleAccount.getId() );

        // Save And Return
        Product savedProduct =  productRepository.save(
                                        productMapper.toProduct( productDto));

        return productMapper.toProductDto( savedProduct );
    }


}
