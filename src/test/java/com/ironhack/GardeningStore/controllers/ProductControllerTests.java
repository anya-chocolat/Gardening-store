package com.ironhack.GardeningStore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.GardeningStore.DTOs.ProductDTO;
import com.ironhack.GardeningStore.DTOs.QuantityDTO;
import com.ironhack.GardeningStore.entities.Product;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProductControllerTests {

    @Autowired
    ProductRepository productRepository;
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
    void addProduct_Product_isCreated() throws Exception {
        ProductDTO product = new ProductDTO(1, "cherry tomato plant", 28);
        String body = objectMapper.writeValueAsString(product);
        MvcResult mvcResult = mockMvc.perform(post("/products").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("cherry tomato plant"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("28"));
    }

    @Test
    void decreaseQuantity_correctQuantity_decreases() throws Exception {
        QuantityDTO quantityDTO = new QuantityDTO(1, 30);
        String body = objectMapper.writeValueAsString(quantityDTO);
        MvcResult mvcResult = mockMvc.perform(patch("/products/quantity").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void deleteById_works() throws Exception {
        mockMvc.perform(delete("/products/2")).andExpect(status().isOk());
    }

    @Test
    void getProductsByDepartment_Department_works() throws Exception {
        String param = objectMapper.writeValueAsString(1);
        MvcResult mvcResult = mockMvc.perform(get("/products").content(param).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("small shovel"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("large shovel"));
    }

    @Test
    void getProductsByDepartment_Empty_works() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/products").content("")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("small shovel"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("large shovel"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("apple tree sapling"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("geranium seed packet"));
    }

    @Test
    void getProductById_works() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/products/1")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("small shovel"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("50"));
    }

}
