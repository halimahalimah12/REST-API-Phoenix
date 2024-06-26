package com.indocyber.RestAPIPhoenix.dtos.roomService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomServiceRequestDto {
    @NotNull
    @NotBlank(message = "Please, Entry Employee Number")
    private final String employeeNumber;
    @NotNull
    @NotBlank(message = "Please, Entry First Name")
    private final String firstName;
    private final String middleName;
    private final String lastName;
    @NotNull
    @NotBlank(message = "Please, Entry Outsourcing Company")
    private final String company;
}
