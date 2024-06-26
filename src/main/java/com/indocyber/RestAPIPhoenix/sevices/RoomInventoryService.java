package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.dtos.roomInventory.RoomInventoryRequestDto;
import com.indocyber.RestAPIPhoenix.models.Inventory;
import com.indocyber.RestAPIPhoenix.models.Room;
import com.indocyber.RestAPIPhoenix.models.RoomInventory;
import com.indocyber.RestAPIPhoenix.repositories.InventoryRepository;
import com.indocyber.RestAPIPhoenix.repositories.RoomInventoryRepository;
import com.indocyber.RestAPIPhoenix.repositories.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomInventoryService {
    private final RoomInventoryRepository roomInventoryRepository;
    private final RoomRepository roomRepository;
    private final InventoryRepository inventoryRepository;

    public RoomInventoryService(RoomInventoryRepository roomInventoryRepository, RoomRepository roomRepository, InventoryRepository inventoryRepository) {
        this.roomInventoryRepository = roomInventoryRepository;
        this.roomRepository = roomRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public String save(RoomInventoryRequestDto dto) {
        Room room = roomRepository.getReferenceById(dto.getRoomNumber());
        Inventory inventory = inventoryRepository.getReferenceById(dto.getInventory());


        roomInventoryRepository.save(RoomInventory.builder()
                .id(dto.getId())
                .room(room)
                .inventory(inventory)
                .quantity(dto.getQuantity())
                .build());

        return "Berhasil di input";
    }

    public String delete(Integer id) {
        roomInventoryRepository.deleteById(id);

        return "Berhasil di hapus";
    }
}
