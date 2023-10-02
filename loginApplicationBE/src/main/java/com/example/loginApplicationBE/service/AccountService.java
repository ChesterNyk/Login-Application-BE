package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.response.UserListDto;

import java.util.List;

public interface AccountService {
    List<UserListDto> userList ();
}
