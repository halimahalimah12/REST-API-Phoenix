package com.indocyber.RestAPIPhoenix.repositories;

import com.indocyber.RestAPIPhoenix.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GuestRepository extends JpaRepository<Guest,String> {
    @Query("""
            SELECT g
            FROM Guest g
            WHERE g.username LIKE %:username%
            """)
    Guest findUsername (@Param("username") String username);
}
