package com.example.loginApplicationBE.controllerTest;

import com.example.loginApplicationBE.controller.AccountController;
import com.example.loginApplicationBE.dtos.response.*;
import com.example.loginApplicationBE.service.AccountService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void testGetAllUser () throws Exception {
        // Define sample resposne body
        UserListDto userListDto = new UserListDto(3L, "manager@example.com", "Clay Wayne", "MANAGER");
        UserListDto userListDto2 = new UserListDto(4L, "user@example.com", "Bruce Thompson", "USER");

        List<UserListDto> response = new ArrayList<>();

        response.add(userListDto);
        response.add(userListDto2);

        // mock behaviour to service
        when(accountService.userList()).thenReturn(response);

        // Perform actual actual
        mockMvc.perform(get("/allUsers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(CommonResponseBody.KEY_RESULT_SUCCESS)))
                .andExpect(jsonPath("$.data.response", notNullValue()))
                .andExpect(jsonPath("$.data.response", hasSize(2)));
    }
}

