package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.dtos.reservation.ReservationRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.reservation.ReservationResponseDto;
import com.indocyber.RestAPIPhoenix.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

@Service
public class ReservartionService {
    private final ReservationRepository reservationRepository;

    public ReservartionService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponseDto totalIncome(ReservationRequestDto dto) {
        YearMonth yearMonth = dto.getMonth();
        Integer tahun = yearMonth.getYear();
        Integer bulan = yearMonth.getMonthValue();
        Double totalIncome = reservationRepository.totalncome(bulan,tahun) ;
        if (totalIncome == null) {
           return ReservationResponseDto.builder()
                   .totalIncome(0.0)
                   .pesan("Tidak ada total income pada bulan ini")
                   .build();
        }

        return ReservationResponseDto.builder()
                .totalIncome(totalIncome)
                .pesan("Berhasil")
                .build();
    }
}
