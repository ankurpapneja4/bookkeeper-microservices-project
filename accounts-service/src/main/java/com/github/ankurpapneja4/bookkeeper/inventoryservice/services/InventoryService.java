package com.github.ankurpapneja4.bookkeeper.inventoryservice.services;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.repository.InventoryRepository;
import com.github.ankurpapneja4.bookkeeper.mapper.InventoryPagedListMapper;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDto;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDtoPagedList;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryPagedListMapper inventoryMapper;

    public InventoryDtoPagedList findAll(Pageable pageable){
        return inventoryMapper.toInventoryDtoPagedList(
                        inventoryRepository.findAll( pageable) );
    }
}
