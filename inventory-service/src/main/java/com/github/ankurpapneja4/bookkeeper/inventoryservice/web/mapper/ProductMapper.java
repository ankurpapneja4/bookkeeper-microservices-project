package com.github.ankurpapneja4.bookkeeper.inventoryservice.web.mapper;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.domain.Product;
import com.github.ankurpapneja4.bookkeeper.mapper.DateMapper;
import com.github.ankurpapneja4.bookkeeper.model.ProductDto;
import org.mapstruct.Mapper;

@Mapper( uses = DateMapper.class, componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductDto dto);

    ProductDto toProductDto(Product product);
}
