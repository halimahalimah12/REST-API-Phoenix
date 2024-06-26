package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.auth.MyAdminDetail;
import com.indocyber.RestAPIPhoenix.auth.MyGuestDetail;
import com.indocyber.RestAPIPhoenix.auth.jwt.JwtService;
import com.indocyber.RestAPIPhoenix.dtos.auth.AuthTokenRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.auth.AuthTokenResponseDto;
import com.indocyber.RestAPIPhoenix.models.Administrator;
import com.indocyber.RestAPIPhoenix.models.Guest;
import com.indocyber.RestAPIPhoenix.repositories.AdministratorRepository;
import com.indocyber.RestAPIPhoenix.repositories.GuestRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class AuthServiceImpl implements  AuthService, UserDetailsService {

    private final AdministratorRepository administratorRepository;
    private final GuestRepository guestRepository;
    private final JwtService jwt;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AdministratorRepository administratorRepository, GuestRepository guestRepository, JwtService jwt, PasswordEncoder passwordEncoder) {
        this.administratorRepository = administratorRepository;
        this.guestRepository = guestRepository;
        this.jwt = jwt;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthTokenResponseDto creatToken(AuthTokenRequestDto dto) {
        var admin = administratorRepository.findUsername(dto.getUsername());
        if(admin != null && passwordEncoder.matches(dto.getPassword(), admin.getPassword())){
            return AuthTokenResponseDto.builder()
                        .token(jwt.generateTokenAdmin(admin))
                        .message(null)
                        .build();
        }

        var guest = guestRepository.findUsername(dto.getUsername());
        if (guest != null && passwordEncoder.matches(dto.getPassword(), guest.getPassword())) {
                return AuthTokenResponseDto.builder()
                        .token(jwt.generateTokenGuest(guest))
                        .message(null)
                        .build();

        }
         return AuthTokenResponseDto.builder()
                .token(null)
                .message("Username or password is incorrect")
                .build();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator admin = administratorRepository.findUsername(username);
        if (admin != null) {
            return MyAdminDetail.builder()
                    .administrator(admin)
                    .build();
        }

        Guest guest = guestRepository.findUsername(username);
        if (guest != null) {
            return MyGuestDetail.builder()
                    .guest(guest)
                    .build();
        }

        throw new UsernameNotFoundException("User not found with username: " + username);

    }


}
