package com.indocyber.RestAPIPhoenix.controllers;

import com.indocyber.RestAPIPhoenix.dtos.roomService.RoomServiceRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.roomService.RoomServiceResponseDto;
import com.indocyber.RestAPIPhoenix.sevices.RoomServiceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roomService")
public class RoomServiceController {
    private final RoomServiceService roomServiceService;

    public RoomServiceController(RoomServiceService roomServiceService) {
        this.roomServiceService = roomServiceService;
    }

    @PostMapping("")
    public ResponseEntity<RoomServiceResponseDto> addRoomService (@Valid @RequestBody RoomServiceRequestDto dto) {
        return  ResponseEntity.ok(roomServiceService.insert(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomServiceResponseDto> getId(@PathVariable String id){
        return ResponseEntity.ok(roomServiceService.getId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<RoomServiceResponseDto> editRoomService(@PathVariable String id, @RequestBody RoomServiceRequestDto dto){
        return ResponseEntity.ok(roomServiceService.update(dto));
    }


}
