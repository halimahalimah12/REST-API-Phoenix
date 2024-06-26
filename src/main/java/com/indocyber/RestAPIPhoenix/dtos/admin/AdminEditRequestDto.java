package com.indocyber.RestAPIPhoenix.dtos.admin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminEditRequestDto {
    private final String username;
    private final String jobTitle;
}
