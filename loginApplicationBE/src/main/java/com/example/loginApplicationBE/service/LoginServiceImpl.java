package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UsersRepository usersRepository;


}
