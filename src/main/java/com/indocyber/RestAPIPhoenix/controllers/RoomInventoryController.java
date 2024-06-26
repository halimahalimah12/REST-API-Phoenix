package com.indocyber.RestAPIPhoenix.controllers;

import com.indocyber.RestAPIPhoenix.dtos.roomInventory.RoomInventoryRequestDto;
import com.indocyber.RestAPIPhoenix.sevices.RoomInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roomInventory")
public class RoomInventoryController {

    private final RoomInventoryService  roomInventoryService;

    public RoomInventoryController(RoomInventoryService roomInventoryService) {
        this.roomInventoryService = roomInventoryService;
    }

    @PostMapping()
    public ResponseEntity<String> insert (@RequestBody RoomInventoryRequestDto dto) {
        return ResponseEntity.ok(roomInventoryService.save(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id){
        return ResponseEntity.ok(roomInventoryService.delete(id));
    }

}
