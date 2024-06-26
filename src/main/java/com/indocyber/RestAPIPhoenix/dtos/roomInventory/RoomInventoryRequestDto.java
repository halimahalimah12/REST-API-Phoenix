package com.indocyber.RestAPIPhoenix.dtos.roomInventory;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoomInventoryRequestDto {
    private final Integer id;
    private final String roomNumber;
    private final String  inventory;
    private final  Integer quantity;
}
