package com.example.loginApplicationBE.controller;

import com.example.loginApplicationBE.dtos.response.*;
import com.example.loginApplicationBE.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Log4j2
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, path= "/allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> loginUser () {
        log.info("BEGIN | All users ");
        CommonResponseBody responseBody = new CommonResponseBody();

        try {
            List<UserListDto> userDetailsDtoList = accountService.userList();

            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("response", userDetailsDtoList);

            responseBody.setResult(CommonResponseBody.KEY_RESULT_SUCCESS);
            responseBody.setData(dataMap);
        } catch (Exception e) {
            log.error("ERROR : " + e);
            responseBody.setResult(CommonResponseBody.KEY_RESULT_FAIL);
            responseBody.setErrorCode("500");
            responseBody.setErrorMessage("Technical Issues");
        } finally {
            log.info("END | All users");
        }

        return new ResponseEntity<>(responseBody.getMap(), HttpStatus.OK);
    }
}
