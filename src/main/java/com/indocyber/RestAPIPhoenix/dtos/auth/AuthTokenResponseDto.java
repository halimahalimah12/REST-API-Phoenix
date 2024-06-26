package com.indocyber.RestAPIPhoenix.dtos.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenResponseDto {
    private final String message;
    private final String token;

}