package com.indocyber.RestAPIPhoenix.auth.jwt;

import com.indocyber.RestAPIPhoenix.models.Administrator;
import com.indocyber.RestAPIPhoenix.models.Guest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements  JwtService{

    @Value("${jwt.secret-key}")
    private String secreteKey;
    @Override
    public String generateTokenAdmin(Administrator admin) {
        return Jwts.builder()
                .subject(admin.getUsername())
                .issuer("http://localhost:8080")
                .issuedAt(new Date(System.currentTimeMillis())) //hh/mm/ss/ms //kpn dibuat
                .expiration(new Date(System.currentTimeMillis() + 24 *60*60*1000))//kpan expired
                .claims()//isi payload
                .add("username",admin.getUsername())
                .and()
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secreteKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String generateTokenGuest(Guest guest) {
        return Jwts.builder()
                .subject(guest.getUsername())
                .issuer("http://localhost:8080")
                .issuedAt(new Date(System.currentTimeMillis())) //hh/mm/ss/ms //kpn dibuat
                .expiration(new Date(System.currentTimeMillis() + 24 *60*60*1000))//kpan expired
                .claims()//isi payload
                .add("username",guest.getUsername())
                .and()
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public Boolean isValid(String token, UserDetails userDetails) {
        return getClaims(token).get("username").equals(userDetails.getUsername());
    }

    @Override
    public Claims getClaims(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private  boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
