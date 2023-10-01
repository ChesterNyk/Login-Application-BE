package com.example.loginApplicationBE.controller;

import com.example.loginApplicationBE.dtos.request.LoginDto;
import com.example.loginApplicationBE.dtos.response.CommonResponseBody;
import com.example.loginApplicationBE.dtos.response.LoginMessageDto;
import com.example.loginApplicationBE.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Log4j2
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST, path= "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> loginUser (@RequestBody LoginDto requestBody) {
        log.info("BEGIN | Login as " + requestBody.getUsername());
        CommonResponseBody responseBody = new CommonResponseBody();

        try {
            LoginMessageDto response = loginService.loginUser(requestBody);

            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("response", response);

            responseBody.setResult(response.getStatus());
            responseBody.setData(dataMap);
        } catch (Exception e) {
            log.error("ERROR : " + e);
            responseBody.setResult(CommonResponseBody.KEY_RESULT_FAIL);
            responseBody.setErrorCode("500");
            responseBody.setErrorMessage("Technical Issues");
        } finally {
            log.info("END | login");
        }

        return new ResponseEntity<>(responseBody.getMap(), HttpStatus.OK);
    }
}
