package com.github.ankurpapneja4.bookkeeper.inventoryservice.services;

import com.github.ankurpapneja4.bookkeeper.exceptions.NotFoundException;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Product;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.repository.ProductRepository;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.services.accountservice.ClientAccountService;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.web.mapper.ProductMapper;
import com.github.ankurpapneja4.bookkeeper.model.AccountDto;
import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import com.github.ankurpapneja4.bookkeeper.model.enums.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ClientAccountService accountService;
    private final ProductMapper productMapper;

    @Transactional( readOnly = true )
    public ProductDto findById( Long productId){
        return productMapper.toProductDto(
                    productRepository.findById( productId ).orElseThrow( () -> new NotFoundException() ));
    }

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
