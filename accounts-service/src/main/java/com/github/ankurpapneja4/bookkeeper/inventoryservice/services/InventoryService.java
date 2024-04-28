package com.github.ankurpapneja4.bookkeeper.inventoryservice.services;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.repository.InventoryRepository;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.repository.ProductRepository;
import com.github.ankurpapneja4.bookkeeper.mapper.InventoryMapper;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDto;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDtoPagedList;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    private final ProductRepository productRepository;

    private final InventoryMapper inventoryMapper;

    @Transactional( readOnly = true)
    public InventoryDtoPagedList findAll(Pageable pageable){
        return inventoryMapper.toInventoryDtoPagedList(
                        inventoryRepository.findAll( pageable) );
    }

    @Transactional( propagation = Propagation.REQUIRED)
    public void addInventory(Long productId, BigDecimal qty, BigDecimal amount){

        // Get Old Inventory
        InventoryDto inventory =  inventoryMapper.toInventoryDto(
                                            inventoryRepository.findByProductIdWithLock( productId )
                                                        .orElseGet(() -> newInventory( productId)));

        // Update Inventory
        inventory.setTotalPurchaseQty( inventory.getTotalPurchaseQty().add( qty    ));
        inventory.setTotalPurchaseAmt( inventory.getTotalPurchaseAmt().add( amount ));

        // Save
        inventoryRepository.save(
                inventoryMapper.toInventory( inventory ));
    }

    private Inventory newInventory( Long productId ){
        return Inventory.builder()
                    .product( productRepository.findById(productId).get() )
                    .totalPurchaseQty( BigDecimal.ZERO )
                    .totalPurchaseAmt( BigDecimal.ZERO )
                    .averagePrice( BigDecimal.ZERO )
                .build();

    }

}
