package com.indocyber.RestAPIPhoenix.controllers;


import com.indocyber.RestAPIPhoenix.dtos.reservation.ReservationRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.reservation.ReservationResponseDto;
import com.indocyber.RestAPIPhoenix.sevices.ReservartionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {

    private final ReservartionService reservartionService;

    public ReservationController(ReservartionService reservartionService) {
        this.reservartionService = reservartionService;
    }

    @PostMapping("/totalIncome")
    public ResponseEntity<ReservationResponseDto> totalIncome (@Valid @RequestBody ReservationRequestDto dto){
        return ResponseEntity.ok(reservartionService.totalIncome(dto));
    }

}
