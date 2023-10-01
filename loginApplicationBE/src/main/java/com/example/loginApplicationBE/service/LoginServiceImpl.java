package com.example.loginApplicationBE.service;

import com.example.loginApplicationBE.dtos.request.LoginDto;
import com.example.loginApplicationBE.dtos.response.CommonResponseBody;
import com.example.loginApplicationBE.dtos.response.LoginMessageDto;
import com.example.loginApplicationBE.dtos.response.PermissionsDto;
import com.example.loginApplicationBE.dtos.response.UserDetailsDto;
import com.example.loginApplicationBE.model.Role;
import com.example.loginApplicationBE.model.RoleFunction;
import com.example.loginApplicationBE.model.Users;
import com.example.loginApplicationBE.model.UsersRole;
import com.example.loginApplicationBE.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService{

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RoleFunctionRepository roleFunctionRepository;

    @Override
    public LoginMessageDto loginUser (LoginDto loginRequest) {
        log.info("BEGIN login for user " + loginRequest.getUsername());
        LoginMessageDto loginMessageDto = new LoginMessageDto();

        Optional<Users> usersOptional = usersRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (usersOptional.isPresent()) {
            Users userInfo = usersOptional.get();
            UserDetailsDto userDetailsDto = new UserDetailsDto();

            // get username and display name from user table
            userDetailsDto.setUsername(userInfo.getUsername());
            userDetailsDto.setName(userInfo.getName());

            Optional<UsersRole> usersRoleOptional = userRoleRepository.findByUserUserId(userInfo.getUserId());
            if (usersRoleOptional.isPresent()) {
                UsersRole usersRole = usersRoleOptional.get();

                // get role name
                Role role = usersRole.getRole();
                userDetailsDto.setRole(role.getRoleName());

                // get list of permission
                List<RoleFunction> roleFunctionOptional = roleFunctionRepository.findByRoleRoleId(role.getRoleId());

                List<PermissionsDto> permissionsDtoList = new ArrayList<>();
                for (RoleFunction roleFunction : roleFunctionOptional) {
                    PermissionsDto permissionsDto = new PermissionsDto();
                    permissionsDto.setCode(roleFunction.getFunction().getFunctionCode());

                    permissionsDtoList.add(permissionsDto);
                }

                userDetailsDto.setPermission(permissionsDtoList);
            }

            loginMessageDto.setStatus(CommonResponseBody.KEY_RESULT_SUCCESS);
            loginMessageDto.setUserInfo(userDetailsDto);
        } else {
            loginMessageDto.setMessage("User does not exists");
            loginMessageDto.setStatus(CommonResponseBody.KEY_RESULT_FAIL);
        }

        log.info("END login for user " + loginRequest.getUsername());

        return loginMessageDto;
    }
}
