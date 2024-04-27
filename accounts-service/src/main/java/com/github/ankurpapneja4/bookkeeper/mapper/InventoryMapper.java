package com.github.ankurpapneja4.bookkeeper.mapper;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Inventory;
import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Product;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDto;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDtoPagedList;
import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper( uses = DateMapper.class, componentModel = "spring")
public interface InventoryMapper {

    Inventory toInventory(InventoryDto dto);

    InventoryDto toInventoryDto(Inventory inventory);

    Product toProduct(ProductDto dto);

    ProductDto toProductDto(Product product);

    List<InventoryDto> toListInventoryDto(List<Inventory> list);

    default InventoryDtoPagedList toInventoryDtoPagedList(Page<Inventory> page){
        return new InventoryDtoPagedList(
                toListInventoryDto( page.getContent() ),
                PageRequest.of( page.getNumber(), page.getSize() ),
                page.getTotalElements()
        );
    }


}
