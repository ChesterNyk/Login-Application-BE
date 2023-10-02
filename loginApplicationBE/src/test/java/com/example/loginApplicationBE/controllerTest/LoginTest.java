package com.example.loginApplicationBE.controllerTest;

import com.example.loginApplicationBE.controller.LoginController;
import com.example.loginApplicationBE.dtos.request.LoginDto;
import com.example.loginApplicationBE.dtos.response.CommonResponseBody;
import com.example.loginApplicationBE.dtos.response.LoginMessageDto;
import com.example.loginApplicationBE.dtos.response.PermissionsDto;
import com.example.loginApplicationBE.dtos.response.UserDetailsDto;
import com.example.loginApplicationBE.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    void testLoginUser () throws Exception {
        // Define sample request body
        LoginDto requestBody = new LoginDto();

        requestBody.setUsername("user@example.com");
        requestBody.setPassword("password");

        // Define sample resposne body
        PermissionsDto permissionsDto = new PermissionsDto();
        permissionsDto.setCode("V01");

        PermissionsDto permissions2Dto = new PermissionsDto();
        permissionsDto.setCode("VL01");

        List<PermissionsDto> permissionsDtoList = new ArrayList<>();
        permissionsDtoList.add(permissionsDto);
        permissionsDtoList.add(permissions2Dto);

        UserDetailsDto userInfo = new UserDetailsDto();
        userInfo.setRole("USER");
        userInfo.setName("mock user");
        userInfo.setUsername("user@example.com");
        userInfo.setPermission(permissionsDtoList);

        LoginMessageDto response = new LoginMessageDto();
        response.setStatus("Success");
        response.setUserInfo(userInfo);

        // mock behaviour to service
        when(loginService.loginUser(requestBody)).thenReturn(response);

        // Perform actual actual
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(CommonResponseBody.KEY_RESULT_SUCCESS)))
                .andExpect(jsonPath("$.data.response", notNullValue()))
                .andExpect(jsonPath("$.data.response.status", is(CommonResponseBody.KEY_RESULT_SUCCESS)))
                .andExpect(jsonPath("$.data.response.userInfo", notNullValue()))
                .andExpect(jsonPath("$.data.response.userInfo.name", is(response.getUserInfo().getName())))
                .andExpect(jsonPath("$.data.response.userInfo.role", is(response.getUserInfo().getRole())))
                .andExpect(jsonPath("$.data.response.userInfo.permission", hasSize(2)));
    }

    // Convert Object ot String
    private static String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
