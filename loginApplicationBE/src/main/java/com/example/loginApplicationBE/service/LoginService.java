package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.request.LoginDto;
import com.example.loginApplicationBE.dtos.response.LoginMessageDto;
import com.example.loginApplicationBE.dtos.response.UserDetailsDto;

public interface LoginService {
    LoginMessageDto loginUser (LoginDto loginRequest);
}
