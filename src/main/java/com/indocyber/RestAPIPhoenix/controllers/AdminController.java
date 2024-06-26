package com.indocyber.RestAPIPhoenix.controllers;

import com.indocyber.RestAPIPhoenix.dtos.admin.AdminEditRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.admin.AdminRequestDto;
import com.indocyber.RestAPIPhoenix.dtos.admin.AdminResponseDto;
import com.indocyber.RestAPIPhoenix.dtos.admin.ChangePassword;
import com.indocyber.RestAPIPhoenix.sevices.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("")
    public ResponseEntity<AdminResponseDto> insert (@RequestBody AdminRequestDto adminRequestDto) {
        return ResponseEntity.ok(adminService.save(adminRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminResponseDto> getByID(@PathVariable String id){
        return ResponseEntity.ok(adminService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> changePassword (@RequestBody ChangePassword changePassword){
        return ResponseEntity.ok(adminService.changePassword(changePassword));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit (@PathVariable String id, @RequestBody AdminEditRequestDto dto){
        return ResponseEntity.ok(adminService.edit(dto));
    }


}
