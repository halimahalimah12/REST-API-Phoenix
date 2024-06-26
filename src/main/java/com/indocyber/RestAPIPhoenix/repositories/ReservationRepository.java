package com.indocyber.RestAPIPhoenix.repositories;

import com.indocyber.RestAPIPhoenix.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Month;
import java.time.Year;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    @Query("""
            SELECT SUM(DATEDIFF(day,res.checkIn,res.checkOut) *  res.cost)
            FROM Reservation res
            WHERE  MONTH(res.checkIn) = :bulan 
            AND YEAR(res.checkIn) = :tahun
            """)
    Double totalncome(@Param("bulan") Integer bulan,
                      @Param("tahun") Integer tahun);
}
