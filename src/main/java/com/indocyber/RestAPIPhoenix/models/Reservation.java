package com.indocyber.RestAPIPhoenix.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Reservations")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @Column(name = "Code")
    private String code;
    @Column(name = "ReservationMethod")
    private ReservationMethod reservationMethod;
    @ManyToOne
    @JoinColumn(name = "RoomNumber")
    private Room roomNumber;
    @ManyToOne
    @JoinColumn(name = "GuestNumber")
    private Guest guestNumber;
    @Column(name = "BookDate")
    private LocalDate bookDate;
    @Column(name = "CheckIn")
    private LocalDate checkIn;
    @Column(name = "CheckOut")
    private LocalDate checkOut;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "PaymentDate")
    private LocalDate paymentDate;
    @Column(name = "PaymentMethod")
    private PaymentMethod paymentMethod;
    @Column(name = "Renmark")
    private String renmark;
}
