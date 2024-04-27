package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper( uses = DateMapper.class, componentModel = "spring")
public interface InventoryMapper {

    @Mappings({
            @Mapping(source="product.id", target="productId"),
            @Mapping(source = "product.name", target = "productName"),
            @Mapping(source = "product.hsnCode", target = "productHsnCode")
    })
    Inventory toInventory(InventoryDto dto);

    @Mappings({
            @Mapping(source = "productId", target = "product.id"),
            @Mapping(source = "productName", target = "product.name"),
            @Mapping(source = "productHsnCode", target= "product.hsnCode")
    })
    InventoryDto toInventoryDto(Inventory inventory);

    List<InventoryDto> toListInventoryDto(List<Inventory> list);
}
