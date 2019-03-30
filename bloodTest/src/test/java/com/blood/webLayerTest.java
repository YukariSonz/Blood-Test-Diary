package com.blood;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class webLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Resource
    private FilterChainProxy springSecurityFilterChain;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is3xxRedirection());
    }

    @Test
    public void loginTest() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void homeTest() throws Exception {
        this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().is3xxRedirection());
    }

    @Test
    public void logoutTest() throws Exception {
        this.mockMvc.perform(get("/logout")).andDo(print()).andExpect(status().is3xxRedirection());
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain)
                .build();
    }

    /**
     * Login by Using Incorrect Credentials Must return Client Error
     */
    @Test
    public void loginWithIncorrectCredentials() throws Exception {
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", "user")
                .param("password", "pass")).andExpect(status().is4xxClientError());
    }

    /**
     * Login by Using Incorrect Request Method
     
    @Test
    public void loginByUsingIncorrectRequestMethod() throws Exception {
        mockMvc.perform(get("/login").param("username", "user").param("password", "passwsord"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void loginWithCorrectCredentials() throws Exception {
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", "user")
                .param("password", "password")).andExpect(status().isOk());
    }
*/


}