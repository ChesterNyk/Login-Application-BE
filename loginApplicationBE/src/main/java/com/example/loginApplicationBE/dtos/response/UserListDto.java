package com.example.loginApplicationBE.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserListDto {
    private Long userId;
    private String userName;
    private String name;
    private String role;
}
