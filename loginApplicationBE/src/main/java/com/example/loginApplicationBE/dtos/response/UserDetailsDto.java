package com.example.loginApplicationBE.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailsDto {
    private String username;
    private String name;
    private String role;
    private List<PermissionsDto> permission;
}
