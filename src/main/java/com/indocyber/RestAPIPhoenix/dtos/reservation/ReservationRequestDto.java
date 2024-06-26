package com.indocyber.RestAPIPhoenix.dtos.reservation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


import java.time.YearMonth;

@Data
@Builder
public class ReservationRequestDto {
    @JsonFormat(pattern = "yyyy-MM")
    @NotNull(message = "Please, Entry Field")

    private YearMonth month;

    // Konstruktor dengan parameter
    @JsonCreator
    public ReservationRequestDto(@JsonProperty("month") YearMonth month) {
        this.month = month;
    }

    // Getter
    public YearMonth getMonth() {
        return month;
    }
}
