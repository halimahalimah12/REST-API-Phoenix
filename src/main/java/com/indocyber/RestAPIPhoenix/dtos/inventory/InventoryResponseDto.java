package com.indocyber.RestAPIPhoenix.dtos.inventory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponseDto {
    private final String name;
    private final Integer stock;
    private final String description;
}
