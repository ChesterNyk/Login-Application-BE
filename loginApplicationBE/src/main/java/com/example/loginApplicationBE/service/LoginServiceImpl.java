package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.request.LoginDto;
import com.example.loginApplicationBE.dtos.response.LoginMessageDto;
import com.example.loginApplicationBE.dtos.response.UserDetailsDto;
import com.example.loginApplicationBE.model.Users;
import com.example.loginApplicationBE.repository.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService{

    @Autowired
    UsersRepository usersRepository;

    public LoginMessageDto loginUser (LoginDto loginRequest) {
        log.info("BEGIN login for user " + loginRequest.getUsername());
        LoginMessageDto loginMessageDto = new LoginMessageDto();

        UserDetailsDto userDetailsDto = new UserDetailsDto();

        Optional<Users> usersOptional = usersRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (usersOptional.isPresent()) {

        } else {
            loginMessageDto.setMessage("User does not exists");
            loginMessageDto.setStatus("Failed");
        }

        return loginMessageDto;
    }
}
