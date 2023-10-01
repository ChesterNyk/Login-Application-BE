package com.example.loginApplicationBE.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginMessageDto {
    private String message;
    private String status;
    private UserDetailsDto userInfo;

    public LoginMessageDto(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
