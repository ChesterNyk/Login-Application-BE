package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.response.UserDetailsDto;
import com.example.loginApplicationBE.dtos.response.UserList;
import com.example.loginApplicationBE.repository.RoleFunctionRepository;
import com.example.loginApplicationBE.repository.UserRoleRepository;
import com.example.loginApplicationBE.repository.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class AccountServiceImpl implements AccountService{

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RoleFunctionRepository roleFunctionRepository;
    @Override
    public List<UserList> userList() {
        log.info("BEGIN Get list if user details");

        return usersRepository.findAllUser();
    }
}
