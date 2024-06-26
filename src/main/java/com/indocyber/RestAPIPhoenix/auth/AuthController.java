package com.indocyber.RestAPIPhoenix.auth;

import com.indocyber.RestAPIPhoenix.dtos.auth.AuthTokenRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.auth.AuthTokenResponseDto;
import com.indocyber.RestAPIPhoenix.sevices.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("")
    public ResponseEntity<AuthTokenResponseDto> createToken(@RequestBody AuthTokenRequestDto dto ) {
        if (dto.getUsername().isBlank() || dto.getPassword().isBlank()){
            return ResponseEntity.badRequest().body(AuthTokenResponseDto.builder()
                    .token(null)
                    .message("Username atau password kosong!")
                    .build());
        }
        return ResponseEntity.ok(authService.creatToken(dto));
    }

}
