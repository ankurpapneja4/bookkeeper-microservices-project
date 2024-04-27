package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDto;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDtoPagedList;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventoryPagedListMapper {

    private final InventoryMapper inventoryMapper;

    public InventoryDtoPagedList toInventoryDtoPagedList(Page<Inventory> page){
        return new InventoryDtoPagedList(
                inventoryMapper.toListInventoryDto( page.getContent() ),
                PageRequest.of( page.getNumber(), page.getSize() ),
                page.getTotalElements()
        );
    }

    public Inventory toInventoy(InventoryDto dto) {
        return inventoryMapper.toInventory(dto);
    }

    public InventoryDto toInventoryDto(Inventory inventory) {
        return inventoryMapper.toInventoryDto(inventory);
    }
}
