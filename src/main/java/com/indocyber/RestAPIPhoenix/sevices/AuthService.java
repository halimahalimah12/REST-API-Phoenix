package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.dtos.auth.AuthTokenRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.auth.AuthTokenResponseDto;

public interface AuthService {
    AuthTokenResponseDto creatToken(AuthTokenRequestDto dto);

}
