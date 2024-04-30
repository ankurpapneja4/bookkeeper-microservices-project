package com.github.ankurpapneja4.bookkeeper.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class InventoryDtoPagedList extends PageImpl<InventoryDto> {
    public InventoryDtoPagedList(List<InventoryDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public InventoryDtoPagedList(List<InventoryDto> content) {
        super(content);
    }

}
