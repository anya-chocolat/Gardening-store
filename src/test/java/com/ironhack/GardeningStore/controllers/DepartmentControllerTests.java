package com.ironhack.GardeningStore.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.GardeningStore.DTOs.ProductDTO;
import com.ironhack.GardeningStore.repositories.DepartmentRepository;
import com.ironhack.GardeningStore.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class DepartmentControllerTests {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void addDepartment_Department_isCreated() throws Exception {
        String body = objectMapper.writeValueAsString("oscar curto");
        MvcResult mvcResult = mockMvc.perform(post("/departments").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("oscar curto"));
    }

}
