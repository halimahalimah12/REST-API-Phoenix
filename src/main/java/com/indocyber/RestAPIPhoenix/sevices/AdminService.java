package com.indocyber.RestAPIPhoenix.sevices;

import com.indocyber.RestAPIPhoenix.dtos.admin.AdminEditRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.admin.AdminRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.admin.AdminResponseDto;
import com.indocyber.RestAPIPhoenix.dtos.admin.ChangePassword;
import com.indocyber.RestAPIPhoenix.models.Administrator;
import com.indocyber.RestAPIPhoenix.repositories.AdministratorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdministratorRepository administratorRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder) {
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AdminResponseDto save(AdminRequestDto adminRequestDto) {
        Administrator administrator = administratorRepository.save(
                Administrator.builder()
                        .username(adminRequestDto.getUsername())
                        .jobTitle(adminRequestDto.getJobTitle())
                        .password(passwordEncoder.encode(adminRequestDto.getPassword()))
                        .build()
        );
        return convertResponseDto(administrator);
    }

    private AdminResponseDto convertResponseDto(Administrator administrator) {
        return AdminResponseDto.builder()
                .username(administrator.getUsername())
                .jobTitle(administrator.getJobTitle())
                .message("Admin berhasil ditambahkan")
                .build();
    }

    public String changePassword(ChangePassword changePassword) {
        Administrator administrator = administratorRepository.findUsername(changePassword.getUsername());

        if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {

            if (passwordEncoder.matches(changePassword.getOldPassword(), administrator.getPassword())) {
                administrator.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
                administratorRepository.save(administrator);
                return "Password berhasil diganti";
            }else {
                return "Password lama salah";
            }
        } else {
            return "Password doesn't match";
        }
    }

    public AdminResponseDto getById(String id) {
        Administrator administrator = administratorRepository.findUsername(id);

        return convertResponseDto(administrator);
    }

    public String edit(AdminEditRequestDto dto) {
        Administrator administrator = administratorRepository.findUsername(dto.getUsername());

        administrator.setJobTitle(dto.getJobTitle());

        administratorRepository.save(administrator);
        return  "Berhasil Edit Data";

    }
}
