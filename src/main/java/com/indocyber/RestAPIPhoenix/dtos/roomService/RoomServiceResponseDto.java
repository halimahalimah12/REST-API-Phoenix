package com.indocyber.RestAPIPhoenix.dtos.roomService;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoomServiceResponseDto {
    private final String employeeNumber;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String company;
}
