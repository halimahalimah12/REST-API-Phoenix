package com.indocyber.RestAPIPhoenix.controllers;

import com.indocyber.RestAPIPhoenix.dtos.inventory.InventoryRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.inventory.InventoryResponseDto;
import com.indocyber.RestAPIPhoenix.sevices.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @PostMapping("")
    public ResponseEntity<InventoryResponseDto> insertInventory(@Valid @RequestBody InventoryRequestDto dto){
        return ResponseEntity.ok(inventoryService.insert(dto));
    }
    @GetMapping("{id}")
    public ResponseEntity<InventoryResponseDto> getById (@PathVariable String id) {
        return ResponseEntity.ok(inventoryService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@Valid @PathVariable String id,@RequestBody InventoryRequestDto dto) {
        return ResponseEntity.ok(inventoryService.editSave(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<InventoryResponseDto> delete (@PathVariable String id) {
        return ResponseEntity.ok(inventoryService.delete(id));
    }

}
