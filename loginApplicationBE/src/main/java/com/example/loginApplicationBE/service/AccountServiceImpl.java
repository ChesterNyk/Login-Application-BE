package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.response.UserList;
import com.example.loginApplicationBE.dtos.response.UserListDto;
import com.example.loginApplicationBE.repository.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class AccountServiceImpl implements AccountService{

    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<UserListDto> userList() {
        log.info("BEGIN Get list if user details");

        List<UserList> userLists = usersRepository.findAllUser();

        List<UserListDto> userListDtosList = new ArrayList<>();

        for (UserList info : userLists) {
            UserListDto userListDto = new UserListDto(info.getUserId(), info.getUsername(), info.getName(), info.getRole());

            userListDtosList.add(userListDto);
        }

        log.info("END Get list of user details");

        return userListDtosList;
    }
}
