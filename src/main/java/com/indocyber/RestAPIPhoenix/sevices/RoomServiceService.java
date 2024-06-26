package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.dtos.roomService.RoomServiceRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.roomService.RoomServiceResponseDto;
import com.indocyber.RestAPIPhoenix.models.RoomService;
import com.indocyber.RestAPIPhoenix.repositories.RoomServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceService {
    private final RoomServiceRepository roomServiceRepository;

    public RoomServiceService(RoomServiceRepository roomServiceRepository) {
        this.roomServiceRepository = roomServiceRepository;
    }

    public RoomServiceResponseDto insert(RoomServiceRequestDto dto) {
        RoomService roomService = convertRoomService(dto);
        return convertRoomServiceResponseDto(roomService);

    }

    private RoomService convertRoomService(RoomServiceRequestDto dto){
        return roomServiceRepository.save(RoomService.builder()
                .employeeNumber(dto.getEmployeeNumber())
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .outsourchingCompany(dto.getCompany())
                .build()) ;
    }

    private RoomServiceResponseDto convertRoomServiceResponseDto(RoomService roomService){
        return RoomServiceResponseDto.builder()
                .employeeNumber(roomService.getEmployeeNumber())
                .firstName(roomService.getFirstName())
                .middleName(roomService.getMiddleName())
                .lastName(roomService.getLastName())
                .company(roomService.getOutsourchingCompany())
                .build();
    }

    private RoomService findId(String id){
        return roomServiceRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Employee Number Not found"));
    }
    public RoomServiceResponseDto update(RoomServiceRequestDto dto) {
        RoomService roomService = findId(dto.getEmployeeNumber());

        roomService.setEmployeeNumber(dto.getEmployeeNumber());
        roomService.setFirstName(dto.getFirstName());
        roomService.setMiddleName(dto.getMiddleName());
        roomService.setLastName(dto.getLastName());
        roomService.setOutsourchingCompany(dto.getCompany());

        roomService = roomServiceRepository.save(roomService);

        return convertRoomServiceResponseDto(roomService);

    }

    public RoomServiceResponseDto getId(String id) {
        RoomService roomService = findId(id);
        return convertRoomServiceResponseDto(roomService);

    }
}
