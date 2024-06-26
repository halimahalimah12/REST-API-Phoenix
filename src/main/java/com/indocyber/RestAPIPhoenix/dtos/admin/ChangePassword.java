package com.indocyber.RestAPIPhoenix.dtos.admin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePassword {
    private final String username;
    private final String oldPassword;
    private final String newPassword;
    private final String confirmPassword;
    private final String jobTitle;
}
