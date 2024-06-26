package com.indocyber.RestAPIPhoenix.dtos.inventory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryRequestDto {
    @NotNull
    @NotBlank(message = "Please, Entry Description")
    private  String name;
    @NotNull(message = "Please, Entry Stock")
    private Integer stock;
    private String description;
}
