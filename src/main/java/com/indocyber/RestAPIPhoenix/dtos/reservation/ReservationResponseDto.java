package com.indocyber.RestAPIPhoenix.dtos.reservation;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReservationResponseDto {
    private final Double totalIncome;
    private final String pesan;
}
