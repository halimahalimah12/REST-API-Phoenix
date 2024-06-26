package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.dtos.inventory.InventoryRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.inventory.InventoryResponseDto;
import com.indocyber.RestAPIPhoenix.models.Inventory;
import com.indocyber.RestAPIPhoenix.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private  final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    private Inventory findInventory(String name){
        return inventoryRepository.findById(name)
                .orElseThrow(()-> new IllegalArgumentException("Not found name inventory"));
    }
    public InventoryResponseDto getById(String name){
         Inventory inventory = findInventory(name);
         return convertResponseDto(inventory);
    }

    public InventoryResponseDto delete(String name) {
        Inventory inventory = findInventory(name);
        inventoryRepository.deleteById(inventory.getName());
        return convertResponseDto(inventory);

    }

    private InventoryResponseDto convertResponseDto(Inventory inventory){
        return InventoryResponseDto.builder()
                .name(inventory.getName())
                .stock(inventory.getStock())
                .description(inventory.getDescription())
                .build();
    }

    public InventoryResponseDto insert(InventoryRequestDto dto) {

        Inventory inventory = inventoryRepository.save(Inventory.builder()
                .name(dto.getName())
                .stock(dto.getStock())
                .description(dto.getDescription())
                .build());
        return convertResponseDto(inventory);
    }

    public String editSave(InventoryRequestDto dto) {
       Inventory inventory= findInventory(dto.getName());
       inventory.setName(dto.getName());
       inventory.setStock(dto.getStock());
       inventory.setDescription(dto.getDescription());
       inventoryRepository.save(inventory);

       return "Inventory berhasil diperbarui";

    }
}
