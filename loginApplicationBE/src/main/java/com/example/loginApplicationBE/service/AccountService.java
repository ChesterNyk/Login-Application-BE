package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.response.UserDetailsDto;
import com.example.loginApplicationBE.dtos.response.UserList;

import java.util.List;

public interface AccountService {
    List<UserList> userList ();
}
