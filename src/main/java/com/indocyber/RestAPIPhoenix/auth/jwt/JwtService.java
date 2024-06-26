package com.indocyber.RestAPIPhoenix.auth.jwt;

import com.indocyber.RestAPIPhoenix.models.Administrator;
import com.indocyber.RestAPIPhoenix.models.Guest;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateTokenAdmin(Administrator admin);
    String generateTokenGuest(Guest guest);
    Boolean isValid(String token, UserDetails userDetails);
    Claims getClaims(String token);
}
