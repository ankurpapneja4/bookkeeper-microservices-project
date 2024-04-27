package com.github.ankurpapneja4.bookkeeper.inventoryservice.web.controller;

import com.github.ankurpapneja4.bookkeeper.inventoryservice.services.InventoryService;
import com.github.ankurpapneja4.bookkeeper.model.InventoryDtoPagedList;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/api/v1/inventory")
    private ResponseEntity<InventoryDtoPagedList> getInventory(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        Assert.isTrue(pageNum >= 0, "Invalid pageNum");
        Assert.isTrue(pageSize >= 0, "Invalid pageSize");

        return ResponseEntity.ok(
                inventoryService.findAll(PageRequest.of(pageNum, pageSize)));
    }
}

