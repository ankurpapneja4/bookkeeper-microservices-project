package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( uses = DateMapper.class, componentModel = "spring")
public interface InventoryMapper {

    Inventory toInventoy(InventoryDto dto);

    InventoryDto toInventoryDto(Inventory inventory);

    List<InventoryDto> toListInventoryDto(List<Inventory> list);
}
